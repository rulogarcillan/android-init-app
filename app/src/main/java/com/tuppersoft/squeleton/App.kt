package com.tuppersoft.squeleton

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.facebook.stetho.Stetho
import com.google.firebase.analytics.FirebaseAnalytics
import com.tuppersoft.skizo.core.extension.loadSharedPreference
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class App : Application() {


    override fun onCreate() {
        super.onCreate()
        FirebaseAnalytics.getInstance(this)
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
        
        AppCompatDelegate.setDefaultNightMode(
            loadSharedPreference(
                "THEME_MODE",
                AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM
            )
        )
    }
}

