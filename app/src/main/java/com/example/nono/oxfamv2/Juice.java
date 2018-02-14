package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Nono on 03-09-17.
 */

public class Juice extends MainActivity {

    private static Product_Stock orange;
    private static Product_Stock tropical;
    private static Product_Stock world;
    private static Product_Stock vidanges;
    private static Product_Stock pomme;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juice_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");
        System.out.println("Log: Recu " + strdata);
        ArrayList<Product_Stock> stockList = (ArrayList<Product_Stock>) getIntent().getSerializableExtra("List");

        System.out.println("Log: Stock list size: "+stockList.size());

        if (orange == null) {

            for (int i = 0; i < stockList.size(); i++) {

                System.out.println("Log: " + stockList.get(i).getName());

                if (stockList.get(i).getName().equals("Orange"))
                    orange = stockList.get(i);
                if (stockList.get(i).getName().equals("Tropical"))
                    tropical = stockList.get(i);
                if (stockList.get(i).getName().equals("Worldsh."))
                    world = stockList.get(i);
                if (stockList.get(i).getName().equals("Pomme"))
                    pomme = stockList.get(i);
                if (stockList.get(i).getName().equals("Vidange"))
                    vidanges = stockList.get(i);
            }
        }

        if (strdata.equals("Prof")) {

            Button back = findViewById(R.id.back_button);

            final Intent backI = new Intent(this, Secure.class);

            stock(orange, (TextView) findViewById(R.id.viewNbreOrange), (TextView) findViewById(R.id.viewOrangePlus), (ImageView) findViewById(R.id.orange_button));
            stock(tropical, (TextView) findViewById(R.id.viewNbreTropical), (TextView) findViewById(R.id.viewTropicalPlus), (ImageView) findViewById(R.id.tropical_button));
            stock(world, (TextView) findViewById(R.id.viewNbreWorld), (TextView) findViewById(R.id.viewWorldPlus), (ImageView) findViewById(R.id.world_button));
            stock(vidanges, (TextView) findViewById(R.id.viewNbreVidange), (TextView) findViewById(R.id.viewVidangePlus), (ImageView) findViewById(R.id.vidange_button));
            stock(pomme, (TextView) findViewById(R.id.viewNbrePomme), (TextView) findViewById(R.id.viewPommePlus), (ImageView) findViewById(R.id.pomme_button));

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

            achat(orange, Jus_orange, (TextView) findViewById(R.id.viewNbreOrange), (TextView) findViewById(R.id.viewOrangePlus), (ImageView) findViewById(R.id.orange_button));
            achat(tropical, Jus_tropical, (TextView) findViewById(R.id.viewNbreTropical), (TextView) findViewById(R.id.viewTropicalPlus), (ImageView) findViewById(R.id.tropical_button));
            achat(world, Jus_world, (TextView) findViewById(R.id.viewNbreWorld), (TextView) findViewById(R.id.viewWorldPlus), (ImageView) findViewById(R.id.world_button));
            achat(vidanges, Jus_vidange, (TextView) findViewById(R.id.viewNbreVidange), (TextView) findViewById(R.id.viewVidangePlus), (ImageView) findViewById(R.id.vidange_button));
            achat(pomme, Jus_pomme, (TextView) findViewById(R.id.viewNbrePomme), (TextView) findViewById(R.id.viewPommePlus), (ImageView) findViewById(R.id.pomme_button));
        }
    }
}