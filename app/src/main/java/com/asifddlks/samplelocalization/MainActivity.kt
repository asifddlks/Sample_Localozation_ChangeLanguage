package com.asifddlks.samplelocalization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.changelanguage.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set Language at beginning
        // Load from SharedPreference
        Utils.changeLanguage(AppPrefs(this).language, this)

        setContentView(R.layout.activity_main)


    }
}