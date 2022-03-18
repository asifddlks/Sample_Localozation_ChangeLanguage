package com.asifddlks.samplelocalization

import android.content.Context
import android.content.SharedPreferences

class AppPrefs(context: Context) {
    private val appSharedPrefs: SharedPreferences = context.getSharedPreferences("Settings", Context.MODE_PRIVATE)
    private val prefsEditor: SharedPreferences.Editor = appSharedPrefs.edit()
    var language: String?
        get() = appSharedPrefs.getString("Language", "en")
        set(language) {
            prefsEditor.putString("Language", language).apply()
        }

}