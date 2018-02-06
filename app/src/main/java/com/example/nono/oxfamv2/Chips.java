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

import static com.example.nono.oxfamv2.R.mipmap.chips_sel;

/**
 * Created by Nono on 24-08-17.
 */

public class Chips extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chips_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");

        if(!(strdata.equals("Prof"))) {
            Button back = findViewById(R.id.back_button);
            back_button(back);

            achat(Chips_sel,(TextView) findViewById(R.id.viewNbreSel),(TextView) findViewById(R.id.viewSelPlus), (ImageView)findViewById(R.id.sel_button));
            achat(Chips_paprika,(TextView) findViewById(R.id.viewNbrePaprika),(TextView) findViewById(R.id.viewPaprikaPlus),(ImageView)findViewById(R.id.paprika_button));
            achat(Chips_tacos,(TextView) findViewById(R.id.viewNbreTacos),(TextView) findViewById(R.id.viewTacosPlus),(ImageView)findViewById(R.id.tacos_button));
            achat (Chips_caca,(TextView) findViewById(R.id.viewNbreCaca),(TextView) findViewById(R.id.viewCacaPlus),(ImageView)findViewById(R.id.caca_button));
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
