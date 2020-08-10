package com.example.financialcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class RdActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2;
    TextView t3,t5,t7;
    RadioButton c1,c2,c3,c4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rd);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        t3=findViewById(R.id.t3);
        t5=findViewById(R.id.t5);
        t7=findViewById(R.id.t7);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);






        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                t3.setText("0.00");
                t5.setText("0.00");
                t7.setText("0.00");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Double p,r,n,si,ma,i,t=null;

                if (e1.getText().toString().equals("") && e2.getText().toString().equals("") && e3.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter all details",Toast.LENGTH_LONG).show();
                }
                else {
                    p=Double.valueOf(e1.getText().toString().trim());
                    r=Double.valueOf(e2.getText().toString().trim())/100.00;
                    n=Double.valueOf(e3.getText().toString().trim());

                    if (c1.isChecked())
                    {
                        t=12.00;

                    }
                    else if (c2.isChecked())
                    {
                        t=4.00;
                    }
                    else if (c3.isChecked()){
                        t=2.00;
                    }
                    else if (c4.isChecked()){
                        t=1.00;
                    }
                    else {
                        Toast.makeText(getApplicationContext(),"Please Select Compound Frequency",Toast.LENGTH_LONG).show();
                    }
                    si=p*(n*(n+1)/2*n)*r/t ;
                    ma=(p*n)+si;
                    t3.setText("₹" +new DecimalFormat("##.##").format(p*n));
                    t5.setText("₹" +new DecimalFormat("##.##").format(ma-p*n));
                    t7.setText("₹" + new DecimalFormat("##.##").format(ma));

                }
                
            }
        });
    }
}
