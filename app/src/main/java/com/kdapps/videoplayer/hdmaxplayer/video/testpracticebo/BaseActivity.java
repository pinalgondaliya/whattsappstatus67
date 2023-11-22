package com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Languagepref.setLanguage(getSharedPreferences("language_change", 0).getString("check_language", ""), this);
        super.onCreate(savedInstanceState);

    }
}