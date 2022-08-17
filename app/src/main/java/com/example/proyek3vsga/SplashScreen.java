package com.example.proyek3vsga;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

@SuppressLint("CustomSplashScreen")
public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int waktu_loading = 4000;
        new Handler().postDelayed(() -> {
            Intent intent = new Intent(SplashScreen.this,LoginActivity.class);
            startActivities(new Intent[]{intent});
            finish();
        }, waktu_loading);
    }
}