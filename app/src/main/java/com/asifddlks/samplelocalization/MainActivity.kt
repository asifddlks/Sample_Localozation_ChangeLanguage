package com.asifddlks.samplelocalization

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.asifddlks.samplelocalization.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Set Language at beginning
        // Load from SharedPreference
        Utils.changeLanguage(this, AppPrefs(this).language)

        setContentView(R.layout.activity_main)


    }
}