package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nono on 02-09-17.
 */

public class Chocolate extends MainActivity {

    private static Product_Stock lait;
    private static Product_Stock noirs;
    private static Product_Stock nois;
    private static Product_Stock praline;
    private static Product_Stock blancs;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chocolate_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");
        System.out.println("Log: Recu " + strdata);
        ArrayList<Product_Stock> stockList = (ArrayList<Product_Stock>) getIntent().getSerializableExtra("List");

        if (lait == null) {

            for (int i = 0; i < stockList.size(); i++) {

                System.out.println("Log: " + stockList.get(i).getName());

                if (stockList.get(i).getName().equals("Lait"))
                    lait = stockList.get(i);
                if (stockList.get(i).getName().equals("Noir"))
                    noirs = stockList.get(i);
                if (stockList.get(i).getName().equals("Noisettes"))
                    nois = stockList.get(i);
                if (stockList.get(i).getName().equals("Praliné"))
                    praline = stockList.get(i);
                if (stockList.get(i).getName().equals("Blanc"))
                    blancs = stockList.get(i);
            }
        }

        if (strdata.equals("Prof")) {

            Button back = findViewById(R.id.back_button);

            final Intent backI = new Intent(this, Secure.class);

            stock(lait, (TextView) findViewById(R.id.viewNbreLait), (TextView) findViewById(R.id.viewLaitPlus), (ImageView) findViewById(R.id.lait_button));
            stock(noirs, (TextView) findViewById(R.id.viewNbreNoir), (TextView) findViewById(R.id.viewNoirPlus), (ImageView) findViewById(R.id.noir_button));
            stock(nois, (TextView) findViewById(R.id.viewNbreNois), (TextView) findViewById(R.id.viewNoisPlus), (ImageView) findViewById(R.id.nois_button));
            stock(praline, (TextView) findViewById(R.id.viewNbrePraline), (TextView) findViewById(R.id.viewPralinePlus), (ImageView) findViewById(R.id.praline_button));
            stock(blancs, (TextView) findViewById(R.id.viewNbreBlanc), (TextView) findViewById(R.id.viewBlancPlus), (ImageView) findViewById(R.id.blanc_button));

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(backI);
                    finish();
                }
            });

        } else {
            Button back = findViewById(R.id.back_button);
            back_button(back);

            achat(lait, Chocolat_lait, (TextView) findViewById(R.id.viewNbreLait), (TextView) findViewById(R.id.viewLaitPlus), (ImageView) findViewById(R.id.lait_button));
            achat(noirs, Chocolat_noir, (TextView) findViewById(R.id.viewNbreNoir), (TextView) findViewById(R.id.viewNoirPlus), (ImageView) findViewById(R.id.noir_button));
            achat(nois, Chocolat_nois, (TextView) findViewById(R.id.viewNbreNois), (TextView) findViewById(R.id.viewNoisPlus), (ImageView) findViewById(R.id.nois_button));
            achat(praline, Chocolat_praline, (TextView) findViewById(R.id.viewNbrePraline), (TextView) findViewById(R.id.viewPralinePlus), (ImageView) findViewById(R.id.praline_button));
            achat(blancs, Chocolat_blanc, (TextView) findViewById(R.id.viewNbreBlanc), (TextView) findViewById(R.id.viewBlancPlus), (ImageView) findViewById(R.id.blanc_button));

        }
    }
}
