package com.partypeople.agent47.hypar;

import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class SplashScreen extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        int splash_time_out = 1500;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent getToSignUpScreen;
                getToSignUpScreen = new Intent(SplashScreen.this, SignupScreen.class);
                startActivity(getToSignUpScreen);
                finish();
            }
        }, splash_time_out);
    }
}
