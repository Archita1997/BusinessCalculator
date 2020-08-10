package com.example.financialcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class InflectionActivity extends AppCompatActivity {

    EditText e1,e2,e3;
    Button b1,b2;
    TextView t3,t5;
    RadioButton c1,c2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflection);
        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        t3=findViewById(R.id.t3);
        t5=findViewById(R.id.t5);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                t3.setText("0.00");
                t5.setText("0.00");
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                if (e1.getText().toString().trim().equals("") && e2.getText().toString().trim().equals("") && e3.getText().toString().trim().equals("")) {
                    Toast.makeText(getApplicationContext(), "Please Enter Delails", Toast.LENGTH_LONG).show();
                } else {
                    Double p, r, t, c, f, n = null;
                    if (e1.getText().toString().equals("") && e2.getText().toString().equals("") && e3.getText().toString().equals("")) {
                        Toast.makeText(getApplicationContext(), "Enter all details", Toast.LENGTH_LONG).show();
                    } else {
                        p = Double.valueOf(e1.getText().toString());
                        r = (Double.valueOf(e2.getText().toString())) / 100.00;
                        t = (Double.valueOf(e3.getText().toString())) / 12.00;
                        if (c1.isChecked()) {
                            n = 12.00;
                        } else if (c2.isChecked()) {
                            n = 1.00;
                        } else {
                            Toast.makeText(getApplicationContext(), "Please Choose Compund Frequency", Toast.LENGTH_LONG).show();
                            p = 0.00;
                        }
                        f = p * (Math.pow(1 + (r / n), n * t));
                        t3.setText("₹" + new DecimalFormat("##.##").format(p));
                        t5.setText("₹" + new DecimalFormat("##.##").format(f));
                    }
                }
            }



        });

    }
}
