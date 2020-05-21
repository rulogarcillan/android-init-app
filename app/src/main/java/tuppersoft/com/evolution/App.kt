package tuppersoft.com.evolution

import android.app.Application
import androidx.appcompat.app.AppCompatDelegate
import com.facebook.stetho.Stetho
import com.google.firebase.analytics.FirebaseAnalytics
import tuppersoft.com.data.repositories.SharedPreferencesRepository.loadPreference
import tuppersoft.com.evolution.core.di.AppComponent
import tuppersoft.com.evolution.core.di.AppModule
import tuppersoft.com.evolution.core.di.DaggerAppComponent

class App : Application() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        DaggerAppComponent
            .builder()
            .appModule(AppModule(this))
            .build()
    }

    override fun onCreate() {
        super.onCreate()
        injectMembers()
        FirebaseAnalytics.getInstance(this)
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
        AppCompatDelegate.setDefaultNightMode(this.loadPreference("THEME_MODE", AppCompatDelegate.MODE_NIGHT_FOLLOW_SYSTEM))
    }

    private fun injectMembers() = appComponent.inject(this)
}

