package com.asifddlks.samplelocalization;

import android.content.Context;
import android.content.SharedPreferences;


public class AppPrefs {

    private SharedPreferences appSharedPrefs;
    private SharedPreferences.Editor prefsEditor;

    public AppPrefs(Context context) {
        this.appSharedPrefs = context.getSharedPreferences("Settings", Context.MODE_PRIVATE);
        this.prefsEditor = appSharedPrefs.edit();
    }


    public void setLanguage(String language){
        prefsEditor.putString("Language",language).apply();
    }

    public String getLanguage(){
        return appSharedPrefs.getString("Language", "en");
    }

}
