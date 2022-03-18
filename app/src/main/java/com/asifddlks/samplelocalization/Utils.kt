package com.asifddlks.samplelocalization

import android.content.Context
import android.content.ContextWrapper
import android.content.res.Configuration
import android.content.res.Resources
import android.os.Build
import android.os.LocaleList
import com.asifddlks.samplelocalization.AppPrefs
import com.google.android.material.internal.ContextUtils
import java.util.*

object Utils {
    fun changeLanguage(context: Context, lang: String?) {
        val locale = Locale(lang)
        /*Locale.setDefault(locale)
        val configuration = Configuration()
        configuration.locale = locale
        context.resources.updateConfiguration(configuration, context.resources.displayMetrics)*/

        val resources: Resources = context.resources
        val configuration: Configuration = resources.configuration
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val localeList = LocaleList(locale)
            LocaleList.setDefault(localeList)
            configuration.setLocales(localeList)
        } else {
            configuration.locale = locale
        }
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N_MR1) {
            //context.createConfigurationContext(configuration)
            resources.updateConfiguration(configuration, resources.displayMetrics)
        } else {
            resources.updateConfiguration(configuration, resources.displayMetrics)
        }


        // Save to SharedPreference
        AppPrefs(context).language = lang
    }

}

