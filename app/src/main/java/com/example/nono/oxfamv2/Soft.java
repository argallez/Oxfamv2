package com.example.nono.oxfamv2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by Nono on 04-09-17.
 */

public class Soft extends MainActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.soft_layout);

        Button back = (Button) findViewById(R.id.back_button);
        back_button(back);
    achat(Soft_cola,(TextView) findViewById(R.id.viewNbreCola),(TextView) findViewById(R.id.viewColaPlus), (ImageView)findViewById(R.id.cola_button));
    achat(Soft_IceTea,(TextView) findViewById(R.id.viewNbreIcetea),(TextView) findViewById(R.id.viewIceteaPlus), (ImageView)findViewById(R.id.icetea_button));
    achat(Soft_limonade,(TextView) findViewById(R.id.viewNbreLimonade),(TextView) findViewById(R.id.viewLimonadePlus), (ImageView)findViewById(R.id.limonade_button));
    }

}
