package com.example.nono.oxfamv2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nono on 03-09-17.
 */

public class Juice extends MainActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.juice_layout);
        Button back = (Button) findViewById(R.id.back_button);
        back_button(back);


        achat(Jus_orange,(TextView) findViewById(R.id.viewNbreOrange),(TextView) findViewById(R.id.viewOrangePlus), (ImageView)findViewById(R.id.orange_button));
        achat(Jus_tropical,(TextView) findViewById(R.id.viewNbreTropical),(TextView) findViewById(R.id.viewTropicalPlus), (ImageView)findViewById(R.id.tropical_button));
        achat(Jus_world,(TextView) findViewById(R.id.viewNbreWorld),(TextView) findViewById(R.id.viewWorldPlus), (ImageView)findViewById(R.id.world_button));
        achat(Jus_vidange,(TextView) findViewById(R.id.viewNbreVidange),(TextView) findViewById(R.id.viewVidangePlus), (ImageView)findViewById(R.id.vidange_button));
        achat(Jus_pomme,(TextView) findViewById(R.id.viewNbrePomme),(TextView) findViewById(R.id.viewPommePlus), (ImageView)findViewById(R.id.pomme_button));
    }
}


