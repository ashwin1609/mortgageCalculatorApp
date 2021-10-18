package com.example.mortgageapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
public Button b1;
public EditText principal;
public EditText interest;
public  EditText amort;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = findViewById(R.id.CalcButton);
        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                principal = findViewById(R.id.Input1);
                interest = findViewById(R.id.Input2);
                amort = findViewById(R.id.Input3);

                // Validating the input fields
                if(principal.getText().toString().length() == 0){
                    principal.setError( "Principal amount is required" );
                }

                else if(interest.getText().toString().length() == 0){
                    interest.setError("Interest is required");
                }

                else if(amort.getText().toString().length() == 0){
                    amort.setError("Amortization period is required");
                }
                else{

                double double_principal = Double.parseDouble(principal.getText().toString());
                double double_interest = Double.parseDouble(interest.getText().toString());
                int int_amort = Integer.parseInt(amort.getText().toString());

                double onePlusR =  1 + (double_interest/1200);
                double r = double_interest/1200;
                int n = int_amort * 12;

                //double mortgage = (double_principal * ((r * (Math.pow((1+r),n)))/(Math.pow((1+r),n) - 1)));
                double mortgage = (double_principal * (r * Math.pow(onePlusR,n))/(Math.pow(onePlusR,n) - 1));
                String r1 = (String.format("%.2f",mortgage));



                Intent i1 = new Intent(MainActivity.this,Result_Activity.class);
                i1.putExtra("mort_result",r1);
                startActivity(i1);
            }}
        }); }
}
