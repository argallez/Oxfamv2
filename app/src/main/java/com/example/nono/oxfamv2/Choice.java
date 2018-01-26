package com.example.nono.oxfamv2;

import android.content.Intent;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.os.Bundle;
/**
 * Created by Nono on 26-01-18.
 */

public class Choice extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choice_layout);

        ImageView myProf = (ImageView) findViewById(R.id.prof_session);
        assert myProf != null;
        myProf.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Intent prof_start = new Intent(Choice.this, Secure.class);
                startActivity(prof_start);
                return false;
            }
        });
        ImageView myStudent = (ImageView) findViewById(R.id.student_session);
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