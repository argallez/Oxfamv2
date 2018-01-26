package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nono on 04-09-17.
 */

public class Barre extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.barre_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");

        if(!(strdata.equals("Prof"))) {
            Button back = (Button) findViewById(R.id.back_button);
            back_button(back);
            achat(Barre_nougat,(TextView) findViewById(R.id.viewNbreNougat),(TextView) findViewById(R.id.viewNougatPlus),(ImageView) findViewById(R.id.nougat_button));
            achat(Barre_sesame,(TextView) findViewById(R.id.viewNbreSesame),(TextView) findViewById(R.id.viewSesamePlus),(ImageView) findViewById(R.id.sesame_button));
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
