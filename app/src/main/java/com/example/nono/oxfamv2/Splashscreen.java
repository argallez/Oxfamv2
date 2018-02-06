package com.example.nono.oxfamv2;

import android.content.Intent;
import android.database.SQLException;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import java.io.IOException;
import java.util.ArrayList;

/**
 * Created by Nono on 04-09-17.
 */

public class Splashscreen extends MainActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splashscreen_layout);
        Thread sleep = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };

        sleep.start();
        final ImageView logo = findViewById(R.id.logo);
        final Animation anim = AnimationUtils.loadAnimation(getBaseContext(),R.anim.rotation);
        logo.startAnimation(anim);
        anim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

                StockDB stock = new StockDB(Splashscreen.this);
                stock.initialization();

                System.out.println("Log: test");
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent main_start= new Intent (Splashscreen.this,Choice.class);
                startActivity(main_start);
                finish();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}
