package com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo;

import android.content.res.Configuration;
import android.content.res.Resources;
import android.util.DisplayMetrics;

import java.util.Locale;

public class Languagepref {
    public static void setLanguage(String str, BaseActivity context) {
        Locale locale = new Locale(str);
        Resources resources = context.getResources();
        DisplayMetrics displayMetrics = resources.getDisplayMetrics();
        Configuration configuration = resources.getConfiguration();
        configuration.setLayoutDirection(locale);
        configuration.locale = locale;
        resources.updateConfiguration(configuration, displayMetrics);
    }
}
