package com.example.mortgageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result_Activity extends AppCompatActivity {
public Button b2;
public TextView result;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        result = findViewById(R.id.result);

        String result1 = getIntent().getStringExtra("mort_result");
        result.setText(result1);

        b2 = findViewById(R.id.BackButton);
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i2 = new Intent(Result_Activity.this,MainActivity.class);
                startActivity(i2);
            }
        });

    }
}