package com.asifddlks.samplelocalization;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

public class Utils {

    public static void changeLanguage(String lang, Context context) {
        Locale locale = new Locale(lang);
        Locale.setDefault(locale);

        Configuration configuration = new Configuration();
        configuration.locale = locale;

        context.getResources().updateConfiguration(configuration, context.getResources().getDisplayMetrics());

        // Save to SharedPreference
        new AppPrefs(context).setLanguage(lang);
    }


}
