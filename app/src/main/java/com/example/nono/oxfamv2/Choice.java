package com.example.nono.oxfamv2;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.Typeface;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.text.InputType;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
import android.widget.Toast;

/**
 * Created by Nono on 26-01-18.
 */

public class Choice extends AppCompatActivity {

    private static final String PRODUCTNAME = "ProductName";
    private static final String DISPONIBILITY = "Disponible";


    @SuppressLint("ClickableViewAccessibility")

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_layout);

        final StockDB STOCK_DB = new StockDB(this);
        final MainActivity MAIN_ACTIVITY = new MainActivity();
        final Produits[] PRODUCTS= MAIN_ACTIVITY.getListeProduits();

        ImageView myProf = findViewById(R.id.prof_session);
        assert myProf != null;
        myProf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                AlertDialog.Builder alert = new AlertDialog.Builder(Choice.this);

                //Creation du titre
                TextView myChoicePsw = new TextView(Choice.this);
                myChoicePsw.setText("Mot de passe");
                myChoicePsw.setTextSize(25);
                myChoicePsw.setTypeface(null, Typeface.BOLD);
                myChoicePsw.setGravity(Gravity.CENTER_HORIZONTAL);
                myChoicePsw.setTextColor(Color.DKGRAY);

                alert.setCustomTitle(myChoicePsw);

                final EditText input = new EditText((Choice.this));
                input.setInputType(InputType.TYPE_CLASS_NUMBER);
                input.setText("");
                input.setGravity(Gravity.CENTER_HORIZONTAL);
                alert.setView(input);

                alert.setPositiveButton("Enter", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        try {
                            int givenPsw = Integer.parseInt(input.getText().toString());

                            if (givenPsw == 1683) {
                                System.out.println("Good psw");
                                Intent prof_start = new Intent(Choice.this, Secure.class);
                                startActivity(prof_start);
                            } else {
                                System.out.println("Wrong psw");
                                Toast.makeText(Choice.this, "Mauvais mot de passe", Toast.LENGTH_SHORT).show();
                            }
                        } catch(Exception e) {
                            Toast.makeText(Choice.this, "Mauvais mot de passe", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
                alert.show();

                return false;
            }
        });

        ImageView myStudent = findViewById(R.id.student_session);
        assert myStudent != null;
        myStudent.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent student_start = new Intent(Choice.this, MainScreen.class);
                startActivity(student_start);
                return false;
            }
        });
    }
}