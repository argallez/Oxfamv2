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

public class Candy extends MainActivity {

    private static Product_Stock Su_Miel;
    private static Product_Stock Sa_Su_Miel;
    private static Product_Stock Bon_Cafe;
    private static Product_Stock Sa_Bon_Cafe;
    private static Product_Stock Oursons;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candy_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");


        System.out.println("Log: Recu " + strdata);
        ArrayList<Product_Stock> stockList = (ArrayList<Product_Stock>) getIntent().getSerializableExtra("List");

        if(Su_Miel == null && Sa_Su_Miel == null) {

            for (int i = 0; i < stockList.size(); i++) {

                System.out.println("Log: " + stockList.get(i).getName());

                if (stockList.get(i).getName().equals("Su. Miel"))
                    Su_Miel = stockList.get(i);
                if (stockList.get(i).getName().equals("Sa. Su. Miel"))
                    Sa_Su_Miel = stockList.get(i);
                if (stockList.get(i).getName().equals("Bon. Café"))
                    Bon_Cafe = stockList.get(i);
                if (stockList.get(i).getName().equals("Sa. Bon. Café."))
                    Sa_Bon_Cafe = stockList.get(i);
                if (stockList.get(i).getName().equals("Oursons"))
                    Oursons = stockList.get(i);
            }
        }

        if(strdata.equals("Prof")) {

            Button back = findViewById(R.id.back_button);

            final Intent backI = new Intent(this, Secure.class);

            stock(Su_Miel, (TextView) findViewById(R.id.viewNbreSuMiel), (TextView) findViewById(R.id.viewSuMielPlus), (ImageView) findViewById(R.id.sumiel_button));
            stock(Sa_Su_Miel, (TextView) findViewById(R.id.viewNbreSaSuMiel), (TextView) findViewById(R.id.viewSaSuMielPlus), (ImageView) findViewById(R.id.sasumiel_button));
            stock(Bon_Cafe, (TextView) findViewById(R.id.viewNbreBonCafe), (TextView) findViewById(R.id.viewBonCafePlus), (ImageView) findViewById(R.id.boncafe_button));
            stock(Sa_Bon_Cafe , (TextView) findViewById(R.id.viewNbreSaBonCafe), (TextView) findViewById(R.id.viewSaBonCafePlus), (ImageView) findViewById(R.id.saboncafe_button));
            stock(Oursons, (TextView) findViewById(R.id.viewNbreSaBonOurson), (TextView) findViewById(R.id.viewSaBonOursonPlus), (ImageView) findViewById(R.id.sabonourson_button));

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
            achat(Su_Miel, Bon_SuMiel, (TextView) findViewById(R.id.viewNbreSuMiel), (TextView) findViewById(R.id.viewSuMielPlus), (ImageView) findViewById(R.id.sumiel_button));
            achat(Sa_Su_Miel, Bon_SaSuMiel, (TextView) findViewById(R.id.viewNbreSaSuMiel), (TextView) findViewById(R.id.viewSaSuMielPlus), (ImageView) findViewById(R.id.sasumiel_button));
            achat(Bon_Cafe, Bon_cafe, (TextView) findViewById(R.id.viewNbreBonCafe), (TextView) findViewById(R.id.viewBonCafePlus), (ImageView) findViewById(R.id.boncafe_button));
            achat(Sa_Bon_Cafe ,Bon_SaCafe, (TextView) findViewById(R.id.viewNbreSaBonCafe), (TextView) findViewById(R.id.viewSaBonCafePlus), (ImageView) findViewById(R.id.saboncafe_button));
            achat(Oursons, Bon_ourson, (TextView) findViewById(R.id.viewNbreSaBonOurson), (TextView) findViewById(R.id.viewSaBonOursonPlus), (ImageView) findViewById(R.id.sabonourson_button));

        }
    }
}
