package com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class LanguageActivity extends BaseActivity {
    public RecyclerView lan_recyclerView;
    public TextView lantext;
    public ArrayList<LanguageModel> languageModelArrayList;
    public SharedPreferences sharedPreferences;
    public SharedPreferences.Editor editor;
    public String stringcode;

    public class a implements View.OnClickListener {
        public a() {
        }

        public void onClick(View view) {
            LanguageActivity.this.onBackPressed();
        }
    }

    public class b implements g {
        public b() {
        }
    }



    public interface g{

    }

    public class c implements View.OnClickListener {
        public c() {
        }

        public void onClick(View view) {
            LanguageActivity.this.editor.putBoolean("checkkk", true);
            LanguageActivity.this.editor.apply();
            LanguageActivity.this.editor.commit();
            if (Utils.isvariable == 7) {
                LanguageActivity.this.startActivity(new Intent(LanguageActivity.this, MainActivity.class));
                Utils.isvariable = 0;
                return;
            }
//            LanguageActivity.this.startActivity(new Intent(LanguageActivity.this, IntroductionActivity.class));
        }
    }

    @Override // androidx.activity.ComponentActivity, c0.h, com.photoarteffect.magiceditor.photolab.Activity.BaseActivity, androidx.fragment.app.p
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setContentView(R.layout.activity_language);
        this.lan_recyclerView = (RecyclerView) findViewById(R.id.lan_recyclerView);
        this.lantext = (TextView) findViewById(R.id.save);
        this.languageModelArrayList = new ArrayList<>();
        findViewById(R.id.back).setOnClickListener(new a());
        this.languageModelArrayList.add(new LanguageModel("English", "en", "English"));
        this.languageModelArrayList.add(new LanguageModel("Chinese", "zh", "中国人"));
        this.languageModelArrayList.add(new LanguageModel("Spanish", "es", "Español"));
        this.languageModelArrayList.add(new LanguageModel("French", "fr", "Français"));
        this.languageModelArrayList.add(new LanguageModel("Hindi", "hi", "हिंदी"));
        this.languageModelArrayList.add(new LanguageModel("Indonesian", "in", "bahasa Indonesia"));
        this.languageModelArrayList.add(new LanguageModel("Russian", "ru", "Русский"));
        this.languageModelArrayList.add(new LanguageModel("German", "de", "Deutsch"));
        this.languageModelArrayList.add(new LanguageModel("Portuguese", "pt", "Português"));
        SharedPreferences sharedPreferences = getSharedPreferences("language_change", 0);
        this.sharedPreferences = sharedPreferences;
        this.stringcode = sharedPreferences.getString("check_language", "");
        this.editor = this.sharedPreferences.edit();
        if (this.stringcode.equals("")) {
            this.stringcode = "en";
        }
        this.lan_recyclerView.setAdapter(new LanguageAdapter(this, this.stringcode, this.languageModelArrayList, null));
        this.lantext.setOnClickListener(new c());
    }
}