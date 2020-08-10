package com.example.financialcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

public class EmicompActivity extends AppCompatActivity {

    EditText e1,e2,e3,e4,e5,e6;
    Button b1,b2;
    TextView a1,a2,a3,a4,a5,a6;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emicomp);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        e4=findViewById(R.id.e4);
        e5=findViewById(R.id.e5);
        e6=findViewById(R.id.e6);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        a1=findViewById(R.id.t01);
        a2=findViewById(R.id.t02);
        a3=findViewById(R.id.t03);
        a4=findViewById(R.id.t04);
        a5=findViewById(R.id.t05);
        a6=findViewById(R.id.t06);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                e2.setText("");
                e3.setText("");
                a1.setText("0.00");
                a2.setText("0.00");
                a3.setText("0.00");
                e4.setText("");
                e5.setText("");
                e6.setText("");
                a4.setText("0.00");
                a5.setText("0.00");
                a6.setText("0.00");
            }
        });


        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double p1,p2,r1,r2,m1,m2,emi1,emi2,ti1,ti2,pay1,pay2;
                p1=Double.valueOf(e1.getText().toString().trim());
                r1=Double.valueOf(e2.getText().toString().trim());
                m1=Double.valueOf(e3.getText().toString().trim());

                p2=Double.valueOf(e4.getText().toString().trim());
                r2=Double.valueOf(e5.getText().toString().trim());
                m2=Double.valueOf(e6.getText().toString().trim());

                ti1=(p1*r1)/(1.819*100);
                emi1=(ti1+p1)/12 ;
                pay1=emi1*m1 ;

                ti2=(p2*r2)/(1.819*100);
                emi2=(ti2+p2)/12 ;
                pay2=emi2*m2 ;
                a1.setText(new DecimalFormat("##.##").format(emi1));
                a2.setText(new DecimalFormat("##.##").format(emi2));
                a3.setText(new DecimalFormat("##.##").format(ti1));
                a4.setText(new DecimalFormat("##.##").format(ti2));
                a5.setText(new DecimalFormat("##.##").format(pay1));
                a6.setText(new DecimalFormat("##.##").format(pay2));
            }
        });
    }

}
