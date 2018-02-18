package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Classe comme les autres categories de produits (pas de DB)
 */

public class Promos extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promos_layout);
        Button back = findViewById(R.id.back_button);
        back_button(back);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");
        System.out.println("Log: Recu " + strdata);
        ArrayList<Product_Stock> stockList = (ArrayList<Product_Stock>) getIntent().getSerializableExtra("List");

        achat(Promos_jusChoco,(TextView) findViewById(R.id.viewNbreJusChoco),(TextView) findViewById(R.id.viewJusChocoPlus), (ImageView)findViewById(R.id.juschoco_button));

    }
}