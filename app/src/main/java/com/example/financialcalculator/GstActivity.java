package com.example.financialcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class GstActivity extends AppCompatActivity {

    Button b1,b2;
    EditText e1;
    TextView t3,t5,t7,t10;
    ArrayList<String> f1;
    RadioButton c1,c2,c3,c4;
    Double p, gr, ga, c, tp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gst);
        e1=findViewById(R.id.e1);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        t3=findViewById(R.id.t3);
        t5=findViewById(R.id.t5);
        t7=findViewById(R.id.t7);
        t10=findViewById(R.id.t10);
        c1=findViewById(R.id.c1);
        c2=findViewById(R.id.c2);
        c3=findViewById(R.id.c3);
        c4=findViewById(R.id.c4);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                e1.setText("");
                t3.setText("0.00");
                t5.setText("0.00");
                t7.setText("0.00");
                t10.setText("0.00");
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    p=Double.valueOf(e1.getText().toString().trim());

                    if (c1.isChecked())
                    {
                        gst(p,5.00);
                    }
                    else if (c2.isChecked())
                    {
                        gst(p,12.00);
                    }
                    else if (c3.isChecked())
                    {
                        gst(p,18.00);
                    }
                    else if (c4.isChecked())
                    {
                        gst(p,28.00);
                    }
                    else{
                        Toast.makeText(getApplicationContext(),"Choose GST Rate",Toast.LENGTH_LONG).show();
                    }



                }catch (Exception ae){
                    Toast.makeText(getApplicationContext(),"Error:"+ae,Toast.LENGTH_LONG).show();
                }


            }
        });
    }
    public void gst(double a,double i)
    {
        ga = (a * i) / 100;
        tp = p + ga;
        c = ga / 2;

        t3.setText("₹" +new DecimalFormat("##.##").format(a));
        t5.setText("₹" +new DecimalFormat("##.##").format(ga));
        t7.setText("₹" +new DecimalFormat("##.##").format(c));
        t10.setText("₹" +new DecimalFormat("##.##").format(tp));
    }
}
