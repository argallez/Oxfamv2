package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by Nono on 27-08-17.
 */

public class MainScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageView myChips = (ImageView)findViewById(R.id.chips_button);
        assert myChips != null;
        myChips.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent chips_start = new Intent(MainScreen.this, Chips.class);
                startActivity(chips_start);
                return false;
            }
        });
        ImageView myChocolate = (ImageView)findViewById(R.id.chocolate_button);
        assert myChocolate != null;
        myChocolate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent chocolate_start = new Intent(MainScreen.this, Chocolate.class);
                startActivity(chocolate_start);
                return false;
            }
        });
        ImageView myJuice = (ImageView)findViewById(R.id.juice_button);
        assert myJuice != null;
        myJuice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent juice_start = new Intent(MainScreen.this, Juice.class);
                startActivity(juice_start);
                return false;
            }
        });
        ImageView myCandy = (ImageView)findViewById(R.id.candy_button);
        assert myCandy != null;
        myCandy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent candy_start = new Intent(MainScreen.this, Candy.class);
                startActivity(candy_start);
                return false;
            }
        });
        ImageView mySoft = (ImageView)findViewById(R.id.soft_button);
        assert mySoft != null;
        mySoft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent soft_start = new Intent(MainScreen.this, Soft.class);
                startActivity(soft_start);
                return false;
            }
        });
        ImageView myBarre = (ImageView)findViewById(R.id.barre_button);
        assert myBarre != null;
        myBarre.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent barre_start = new Intent(MainScreen.this, Barre.class);
                startActivity(barre_start);
                return false;
            }
        });
        Button myAddition = (Button) findViewById(R.id.addition_button);
        assert myAddition != null;
        myAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addition_start= new Intent(MainScreen.this, Name.class);
                startActivity(addition_start);
            }
        });
        ImageView myPromos = (ImageView)findViewById(R.id.promos_button);
        assert myPromos!= null;
        myPromos.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent promos_start = new Intent(MainScreen.this, Promos.class);
                startActivity(promos_start);
                return false;
            }
        });
    }


}
