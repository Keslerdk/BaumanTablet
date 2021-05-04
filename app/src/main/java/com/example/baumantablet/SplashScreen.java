package com.example.baumantablet;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

public class SplashScreen extends AppCompatActivity {

    ImageView splashScreenBg;
    TextView appName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        splashScreenBg = findViewById(R.id.splashScreenBg);
        appName = findViewById(R.id.appName);

        appName.setTranslationX(-1600);
        appName.setAlpha(0);
        appName.animate().translationX(0).alpha(1).setDuration(1000).setStartDelay(1000).start();

        Glide.with(this)
                .load(R.drawable.ic_background)
                .into(splashScreenBg);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(SplashScreen.this, LoginScreen.class);
                startActivity(intent);
            }
        }, 3000);
    }


}