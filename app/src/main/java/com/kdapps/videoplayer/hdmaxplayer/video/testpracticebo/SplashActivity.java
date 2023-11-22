package com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

public class SplashActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    public boolean checklanguage;
    public boolean chkinto;
    public static final /* synthetic */ int K = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        SharedPreferences sharedPreferences = getSharedPreferences("language_change", 0);
        this.sharedPreferences = sharedPreferences;
        String string = sharedPreferences.getString("check_language", "");
        this.checklanguage = this.sharedPreferences.getBoolean("checkkk", false);
        this.chkinto = this.sharedPreferences.getBoolean("check_intro", false);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                SplashActivity splashActivity = SplashActivity.this;
                int i10 = SplashActivity.K;
                splashActivity.startnew();

            }
        },2000);
    }

    private void startnew() {
        if (!this.checklanguage) {
            startActivity(new Intent(this, LanguageActivity.class));
        } else if (this.chkinto) {
            startActivity(new Intent(this, MainActivity.class));
        } else {
//            startActivity(new Intent(this, IntroductionActivity.class));
        }

    }
}