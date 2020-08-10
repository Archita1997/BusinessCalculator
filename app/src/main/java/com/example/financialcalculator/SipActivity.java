package com.example.financialcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class SipActivity extends AppCompatActivity {
    EditText e1,e2,e3;
    Button b1,b2;
    TextView t3,t5,t7;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sip);

        e1=findViewById(R.id.e1);
        e2=findViewById(R.id.e2);
        e3=findViewById(R.id.e3);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);
        t3=findViewById(R.id.t3);
        t5=findViewById(R.id.t5);
        t7=findViewById(R.id.t7);

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
                Double p,r,n,i ,fv,ai,wg;
                if (e1.getText().toString().equals("") && e2.getText().toString().equals("") && e3.getText().toString().equals(""))
                {
                    Toast.makeText(getApplicationContext(),"Enter all details",Toast.LENGTH_LONG).show();
                }
                else {
                    p=Double.valueOf(e1.getText().toString().trim());
                    r=Double.valueOf(e2.getText().toString().trim());
                    n=Double.valueOf(e3.getText().toString().trim());

                    i=r/(100*12) ;

                    fv=p*((Math.pow(1+i , n)-1)/i)*(1+i) ;
                    ai=p*n;
                    wg=fv-ai ;

                    t3.setText("₹" +new DecimalFormat("##.##").format(fv));
                    t5.setText("₹" +new DecimalFormat("##.##").format(ai));
                    t7.setText("₹" +new DecimalFormat("##.##").format(wg));

                }



            }
        });
    }
}
