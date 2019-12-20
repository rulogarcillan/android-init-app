package tuppersoft.com.evolution

import android.app.Application
import com.facebook.stetho.Stetho
import com.google.firebase.analytics.FirebaseAnalytics
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
        Stetho.initializeWithDefaults(this)
    }

    private fun injectMembers() = appComponent.inject(this)
}

