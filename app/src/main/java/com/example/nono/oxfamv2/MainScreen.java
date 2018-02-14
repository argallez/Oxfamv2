package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Nono on 27-08-17.
 */

public class MainScreen extends AppCompatActivity {

    List<Product_Stock> stock = StockDB.getData();

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button backProf = findViewById(R.id.backProf);
        backProf.setVisibility(View.GONE);

        Button studentButton = findViewById(R.id.backStudent);
        back(studentButton);

        ImageView myChips = findViewById(R.id.chips_button);
        assert myChips != null;
        myChips.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent chips_start = new Intent(MainScreen.this, Chips.class);
                chips_start.putExtra("Uniqid","Student");
                chips_start.putExtra("List", (ArrayList<? extends Parcelable>) stock);
                startActivity(chips_start);
                return false;
            }
        });

        ImageView myChocolate = findViewById(R.id.chocolate_button);
        assert myChocolate != null;
        myChocolate.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent chocolate_start = new Intent(MainScreen.this , Chocolate.class);
                chocolate_start.putExtra("Uniqid","Student");
                chocolate_start.putExtra("List", (ArrayList<? extends Parcelable>) stock);
                startActivity(chocolate_start);
                return false;
            }
        });

        ImageView myJuice = findViewById(R.id.juice_button);
        assert myJuice != null;
        myJuice.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent juice_start = new Intent(MainScreen.this, Juice.class);
                juice_start.putExtra("Uniqid","Student");
                juice_start.putExtra("List", (ArrayList<? extends Parcelable>) stock);
                startActivity(juice_start);
                return false;
            }
        });

        ImageView myCandy = findViewById(R.id.candy_button);
        assert myCandy != null;
        myCandy.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent candy_start = new Intent(MainScreen.this, Candy.class);
                candy_start.putExtra("Uniqid","Student");
                candy_start.putExtra("List", (ArrayList<? extends Parcelable>) stock);
                startActivity(candy_start);
                return false;
            }
        });

        ImageView mySoft = findViewById(R.id.soft_button);
        assert mySoft != null;
        mySoft.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent soft_start = new Intent(MainScreen.this, Soft.class);
                soft_start.putExtra("Uniqid","Student");
                soft_start.putExtra("List", (ArrayList<? extends Parcelable>) stock);
                startActivity(soft_start);
                return false;
            }
        });

        ImageView myBarre = findViewById(R.id.barre_button);
        assert myBarre != null;
        myBarre.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent barre_start = new Intent(MainScreen.this, Barre.class);
                barre_start.putExtra("Uniqid","Student");
                barre_start.putExtra("List", (ArrayList<? extends Parcelable>) stock);
                startActivity(barre_start);
                return false;
            }
        });

        Button myAddition = findViewById(R.id.addition_button);
        assert myAddition != null;
        myAddition.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent addition_start= new Intent(MainScreen.this, Name.class);
                addition_start.putExtra("Uniqid","Student");
                addition_start.putExtra("List", (ArrayList<? extends Parcelable>) stock);
                startActivity(addition_start);
            }
        });

        ImageView myPromos = findViewById(R.id.promos_button);
        assert myPromos!= null;
        myPromos.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent promos_start = new Intent(MainScreen.this, Promos.class);
                promos_start.putExtra("Uniqid","Student");
                promos_start.putExtra("List", (ArrayList<? extends Parcelable>) stock);
                startActivity(promos_start);
                return false;
            }
        });
    }

    public void back(Button button) {
        final Intent backI = new Intent(MainScreen.this, Choice.class);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(backI);
            }
        });
    }
}
