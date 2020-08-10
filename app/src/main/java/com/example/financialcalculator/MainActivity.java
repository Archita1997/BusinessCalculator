package com.example.financialcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView icon;
    Animation fromtop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        icon=(ImageView)findViewById(R.id.i1);
        fromtop= AnimationUtils.loadAnimation(this,R.anim.fromtop);

        icon.setAnimation(fromtop);

        Handler h=new Handler();
        h.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent i=new Intent(getApplicationContext(),SecondActivity.class);
                startActivity(i);
                finish();
            }
        },4000);
    }
}
