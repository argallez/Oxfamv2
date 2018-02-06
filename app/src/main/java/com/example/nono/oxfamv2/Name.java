package com.example.nono.oxfamv2;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by Nono on 04-09-17.
 */

public class Name extends MainActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.name_layout);

        final EditText editName1 = findViewById(R.id.name1);
        final EditText editName2 = findViewById(R.id.name2);
        final EditText editName3 = findViewById(R.id.name3);
        final EditText editName4 = findViewById(R.id.name4);
        Button myButton = findViewById(R.id.button);
        myButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent addition_start= new Intent (Name.this,FinalAddition.class);
                vendeur1=editName1.getText().toString();
                vendeur2=editName2.getText().toString();
                vendeur3=editName3.getText().toString();
                vendeur4=editName4.getText().toString();
                startActivity(addition_start);
                finish();
            }
        });

    }
}
