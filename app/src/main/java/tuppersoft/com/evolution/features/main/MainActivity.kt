package tuppersoft.com.evolution.features.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatDelegate
import kotlinx.android.synthetic.main.activity_main.fab
import kotlinx.android.synthetic.main.activity_main.toolbar
import tuppersoft.com.data.repositories.SharedPreferencesRepository.loadPreference
import tuppersoft.com.data.repositories.SharedPreferencesRepository.savePreference
import tuppersoft.com.evolution.R
import tuppersoft.com.evolution.core.platform.GlobalActivity

class MainActivity : GlobalActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        delegate.localNightMode = this.loadPreference("THEME_MODE", delegate.localNightMode)
        fab.setOnClickListener {
            changeTheme()
        }
    }

    private fun changeTheme() {
        if (this.loadPreference(
                "THEME_MODE",
                delegate.localNightMode
            ) == AppCompatDelegate.MODE_NIGHT_YES
        ) {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_NO
        } else {
            delegate.localNightMode = AppCompatDelegate.MODE_NIGHT_YES
        }
        this.savePreference("THEME_MODE", delegate.localNightMode)
    }
}
