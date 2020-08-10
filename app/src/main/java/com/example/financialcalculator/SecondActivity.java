package com.example.financialcalculator;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telecom.PhoneAccountHandle;
import android.telephony.VisualVoicemailService;
import android.telephony.VisualVoicemailSms;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RatingBar;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

public class SecondActivity extends AppCompatActivity {
    DrawerLayout drawerLayout;
    Toolbar toolbar;
    ActionBarDrawerToggle actionBarDrawerToggle;
    NavigationView navigationView;
    long back;
    Toast backToast;

    Button i1,i2,i3,i4,i5,i6,i7,i8,i9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        setupToolbar();

        i1=findViewById(R.id.b1);
        navigationView=findViewById(R.id.nav_view);
        i2=findViewById(R.id.b2);
        i3=findViewById(R.id.b3);
        i4=findViewById(R.id.b4);
        i5=findViewById(R.id.b5);
        i6=findViewById(R.id.b6);
        i7=findViewById(R.id.b7);
        i8=findViewById(R.id.b8);
        i9=findViewById(R.id.b9);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @SuppressLint("LongLogTag")
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId())
                {
                    case R.id.home :
                        startActivity(new Intent(getApplicationContext(),SecondActivity.class));
                        finish();
                        break;
                    case R.id.help:
                        Toast.makeText(getApplicationContext(),"Go to Home section and calculate required things",Toast.LENGTH_LONG).show();
                        break;
                    case R.id.contact:
                        Intent i=new Intent(Intent.ACTION_DIAL);
                        i.setData(Uri.parse("tel:9563300123"));
                        startActivity(i);
                        break;
                    case R.id.about:
                        android.app.AlertDialog.Builder alert1 = new AlertDialog.Builder(SecondActivity.this);
                        alert1.setCancelable(false);
                        alert1.setTitle("About");
                        alert1.setMessage("A financial calculator or business calculator is a calculator that performs financial functions " +
                                "commonly needed in business and commerce communities.By using this application one can easily calculate " +
                                "EMI,SIP,PFF,RD,GST,FD and also can compare EMI, find Compound Interest and calculate Inflection.  " +
                                "It is ideal for phone and tablet, this application includes the complete package of financial calculators.");

                        alert1.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        });
                        alert1.create().show();
                        break;
                    case R.id.share:
                        Intent intent=new Intent(Intent.ACTION_SEND);
                        intent.setType("text/plain");
                        String shareBody="Financial Calculator";
                        String shareSub="Financial Calculator";
                        intent.putExtra(Intent.EXTRA_SUBJECT,shareSub);
                        intent.putExtra(Intent.EXTRA_TEXT,shareBody);
                        startActivity(Intent.createChooser(intent,"Share Using"));
                        break;
                    case R.id.rate:
                        Toast.makeText(SecondActivity.this, "Coming Soon", Toast.LENGTH_LONG).show();


                }
                return false;

            }
        });

        i1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),EmiActivity.class);
                startActivity(i);
            }
        });
        i2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),SipActivity.class);
                startActivity(i);
            }
        });
        i3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),PpfActivity.class);
                startActivity(i);

            }
        });
      i4.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(getApplicationContext(),RdActivity.class);
              startActivity(i);
          }
      });
      i5.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(getApplicationContext(),GstActivity.class);
              startActivity(i);
          }
      });
      i6.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(getApplicationContext(),FdActivity.class);
              startActivity(i);
          }
      });
      i7.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(getApplicationContext(),EmicompActivity.class);
              startActivity(i);
          }
      });
      i8.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(getApplicationContext(),CIinterestActivity.class);
              startActivity(i);
          }
      });
      i9.setOnClickListener(new View.OnClickListener() {
          @Override
          public void onClick(View v) {
              Intent i=new Intent(getApplicationContext(),InflectionActivity.class);
              startActivity(i);
          }
      });
    }

    public void setupToolbar()
    {
        drawerLayout=findViewById(R.id.drawerlayout);
        toolbar=findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        actionBarDrawerToggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    public void onBackPressed() {

        if (back+2000>System.currentTimeMillis()){
            backToast.cancel();
            super.onBackPressed();
            return;
        }else {
            backToast=Toast.makeText(getApplicationContext(),"please back again to exit",Toast.LENGTH_SHORT);
            backToast.show();
        }
        back=System.currentTimeMillis();
    }
}
