package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewDebug;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import static com.example.nono.oxfamv2.R.mipmap.chips_sel;

/**
 * Created by Nono on 24-08-17.
 */

public class Chips extends MainActivity {

    private static Product_Stock sel;
    private static Product_Stock paprika;
    private static Product_Stock tacos;
    private static Product_Stock cacahuetes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chips_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");

        System.out.println("Log: Recu " + strdata);
        ArrayList<Product_Stock> stockList = (ArrayList<Product_Stock>) getIntent().getSerializableExtra("List");

        if (sel == null) {

            for (int i = 0; i < stockList.size(); i++) {

                System.out.println("Log: " + stockList.get(i).getName());

                if (stockList.get(i).getName().equals("Sel"))
                    sel = stockList.get(i);
                if (stockList.get(i).getName().equals("Paprika"))
                    paprika = stockList.get(i);
                if (stockList.get(i).getName().equals("Tacos"))
                    tacos = stockList.get(i);
                if (stockList.get(i).getName().equals("Cacahuètes"))
                    cacahuetes = stockList.get(i);
            }
        }

        if (strdata.equals("Prof")) {

            Button back = findViewById(R.id.back_button);

            final Intent backI = new Intent(this, Secure.class);
            stock(sel, (TextView) findViewById(R.id.viewNbreSel), (TextView) findViewById(R.id.viewSelPlus), (ImageView) findViewById(R.id.sel_button));
            stock(paprika, (TextView) findViewById(R.id.viewNbrePaprika), (TextView) findViewById(R.id.viewPaprikaPlus), (ImageView) findViewById(R.id.paprika_button));
            stock(tacos, (TextView) findViewById(R.id.viewNbreTacos), (TextView) findViewById(R.id.viewTacosPlus), (ImageView) findViewById(R.id.tacos_button));
            stock(cacahuetes, (TextView) findViewById(R.id.viewNbreCaca), (TextView) findViewById(R.id.viewCacaPlus), (ImageView) findViewById(R.id.caca_button));

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

            achat(sel, Chips_sel, (TextView) findViewById(R.id.viewNbreSel), (TextView) findViewById(R.id.viewSelPlus), (ImageView) findViewById(R.id.sel_button));
            achat(paprika, Chips_paprika, (TextView) findViewById(R.id.viewNbrePaprika), (TextView) findViewById(R.id.viewPaprikaPlus), (ImageView) findViewById(R.id.paprika_button));
            achat(tacos, Chips_tacos, (TextView) findViewById(R.id.viewNbreTacos), (TextView) findViewById(R.id.viewTacosPlus), (ImageView) findViewById(R.id.tacos_button));
            achat(cacahuetes, Chips_caca, (TextView) findViewById(R.id.viewNbreCaca), (TextView) findViewById(R.id.viewCacaPlus), (ImageView) findViewById(R.id.caca_button));

        }
    }
}
