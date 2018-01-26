package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nono on 02-09-17.
 */

public class Chocolate extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chocolate_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");

        if(!(strdata.equals("Prof"))) {
            Button back = (Button) findViewById(R.id.back_button);
            back_button(back);
            achat(Chocolat_lait,(TextView) findViewById(R.id.viewNbreLait),(TextView) findViewById(R.id.viewLaitPlus), (ImageView)findViewById(R.id.lait_button));
            achat(Chocolat_noir,(TextView) findViewById(R.id.viewNbreNoir),(TextView) findViewById(R.id.viewNoirPlus), (ImageView)findViewById(R.id.noir_button));
            achat(Chocolat_nois,(TextView) findViewById(R.id.viewNbreNois),(TextView) findViewById(R.id.viewNoisPlus), (ImageView)findViewById(R.id.nois_button));
            achat(Chocolat_praline,(TextView) findViewById(R.id.viewNbrePraline),(TextView) findViewById(R.id.viewPralinePlus), (ImageView)findViewById(R.id.praline_button));
            achat(Chocolat_blanc,(TextView) findViewById(R.id.viewNbreBlanc),(TextView) findViewById(R.id.viewBlancPlus), (ImageView)findViewById(R.id.blanc_button));
        }
        else {
            Button back = findViewById(R.id.back_button);

            final Intent backI = new Intent(this, Secure.class);

            back.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    startActivity(backI);
                    finish();
                }
            });
        }
    }
}
