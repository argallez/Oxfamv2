package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nono on 04-09-17.
 */

public class Soft extends MainActivity {

    private static Product_Stock coca;
    private static Product_Stock iceTea;
    private static Product_Stock limonade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");
        System.out.println("Log: Recu " + strdata);
        ArrayList<Product_Stock> stockList = (ArrayList<Product_Stock>) getIntent().getSerializableExtra("List");

        if (coca == null) {

            for (int i = 0; i < stockList.size(); i++) {

                System.out.println("Log: " + stockList.get(i).getName());

                if (stockList.get(i).getName().equals("Coca"))
                    coca = stockList.get(i);
                if (stockList.get(i).getName().equals("Ice Tea"))
                    iceTea = stockList.get(i);
                if (stockList.get(i).getName().equals("Limonade"))
                    limonade = stockList.get(i);
            }
        }

        if (strdata.equals("Prof")) {

            Button back = findViewById(R.id.back_button);

            final Intent backI = new Intent(this, Secure.class);

            stock(coca, (TextView) findViewById(R.id.viewNbreCola),(TextView) findViewById(R.id.viewColaPlus), (ImageView)findViewById(R.id.cola_button));
            stock(iceTea, (TextView) findViewById(R.id.viewNbreIcetea),(TextView) findViewById(R.id.viewIceteaPlus), (ImageView)findViewById(R.id.icetea_button));
            stock(limonade, (TextView) findViewById(R.id.viewNbreLimonade),(TextView) findViewById(R.id.viewLimonadePlus), (ImageView)findViewById(R.id.limonade_button));

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(backI);
                    finish();
                }
            });
        }

        else {
            Button back = findViewById(R.id.back_button);
            back_button(back);

            achat(coca, Soft_cola,(TextView) findViewById(R.id.viewNbreCola),(TextView) findViewById(R.id.viewColaPlus), (ImageView)findViewById(R.id.cola_button));
            achat(iceTea, Soft_IceTea,(TextView) findViewById(R.id.viewNbreIcetea),(TextView) findViewById(R.id.viewIceteaPlus), (ImageView)findViewById(R.id.icetea_button));
            achat(limonade, Soft_limonade,(TextView) findViewById(R.id.viewNbreLimonade),(TextView) findViewById(R.id.viewLimonadePlus), (ImageView)findViewById(R.id.limonade_button));
        }
    }
}