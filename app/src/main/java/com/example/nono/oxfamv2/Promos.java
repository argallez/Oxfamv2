package com.example.nono.oxfamv2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nono on 02-11-17.
 */

public class Promos extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.promos_layout);
        Button back = findViewById(R.id.back_button);
        back_button(back);

    achat(Promos_jusChoco,(TextView) findViewById(R.id.viewNbreJusChoco),(TextView) findViewById(R.id.viewJusChocoPlus), (ImageView)findViewById(R.id.juschoco_button));
    }
}