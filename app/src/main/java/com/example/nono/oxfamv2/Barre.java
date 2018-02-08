package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.util.Log;

import java.util.ArrayList;

/**
 * Created by Nono on 04-09-17.
 */

public class Barre extends MainActivity {

    Product_Stock Nougat;
    Product_Stock Sesam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barre_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");
        System.out.println("Log: Recu " + strdata);
        ArrayList<Product_Stock> stockList = (ArrayList<Product_Stock>) getIntent().getSerializableExtra("List");

        if (strdata.equals("Prof")) {
            Button back = findViewById(R.id.back_button);

            final Intent backI = new Intent(this, Secure.class);

            for(int i = 0; i < stockList.size(); i++) {

                System.out.println("Log: " + stockList.get(i).getName());

                if(stockList.get(i).getName().equals("Nougat"))
                    Nougat = stockList.get(i);
                if(stockList.get(i).getName().equals("Sésame"))
                    Sesam = stockList.get(i);
            }

            System.out.println("Log: " +Nougat.getName());
            System.out.println("Log: " +Sesam.getName());

            stock(Nougat, (TextView) findViewById(R.id.viewNbreNougat), (TextView) findViewById(R.id.viewNougatPlus), (ImageView) findViewById(R.id.nougat_button));
            stock(Sesam, (TextView) findViewById(R.id.viewNbreSesame), (TextView) findViewById(R.id.viewSesamePlus), (ImageView) findViewById(R.id.sesame_button));

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
            achat(Barre_nougat, (TextView) findViewById(R.id.viewNbreNougat), (TextView) findViewById(R.id.viewNougatPlus), (ImageView) findViewById(R.id.nougat_button));
            achat(Barre_sesame, (TextView) findViewById(R.id.viewNbreSesame), (TextView) findViewById(R.id.viewSesamePlus), (ImageView) findViewById(R.id.sesame_button));
        }
    }
}
