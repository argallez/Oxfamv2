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

public class Candy extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.candy_layout);

        Intent intent = this.getIntent();
        String strdata = intent.getExtras().getString("Uniqid");

        if(!(strdata.equals("Prof"))) {
            Button back = (Button) findViewById(R.id.back_button);
            back_button(back);
            achat(Bon_SuMiel, (TextView) findViewById(R.id.viewNbreSuMiel), (TextView) findViewById(R.id.viewSuMielPlus), (ImageView) findViewById(R.id.sumiel_button));
            achat(Bon_SaSuMiel, (TextView) findViewById(R.id.viewNbreSaSuMiel), (TextView) findViewById(R.id.viewSaSuMielPlus), (ImageView) findViewById(R.id.sasumiel_button));
            achat(Bon_cafe, (TextView) findViewById(R.id.viewNbreBonCafe), (TextView) findViewById(R.id.viewBonCafePlus), (ImageView) findViewById(R.id.boncafe_button));
            achat(Bon_SaCafe, (TextView) findViewById(R.id.viewNbreSaBonCafe), (TextView) findViewById(R.id.viewSaBonCafePlus), (ImageView) findViewById(R.id.saboncafe_button));
            achat(Bon_ourson, (TextView) findViewById(R.id.viewNbreSaBonOurson), (TextView) findViewById(R.id.viewSaBonOursonPlus), (ImageView) findViewById(R.id.sabonourson_button));
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
