package com.kdapps.videoplayer.hdmaxplayer.video.testpracticebo;

public class LanguageModel {
    public String language_code;
    public String language_name;
    public String translate_name;

    public LanguageModel(String str, String str2, String str3) {
        this.language_name = str;
        this.language_code = str2;
        this.translate_name = str3;
    }

    public String getLanguage_code() {
        return this.language_code;
    }

    public String getLanguage_name() {
        return this.language_name;
    }

    public String getTranslate_name() {
        return this.translate_name;

    }
    public void setLanguage_code(String str) {
        this.language_code = str;
    }

    public void setLanguage_name(String str) {
        this.language_name = str;
    }

    public void setTranslate_name(String str) {
        this.translate_name = str;
    }
}