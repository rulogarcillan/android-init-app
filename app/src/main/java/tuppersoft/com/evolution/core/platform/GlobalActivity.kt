package tuppersoft.com.evolution.core.platform

import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import tuppersoft.com.evolution.App
import tuppersoft.com.evolution.core.di.AppComponent

abstract class GlobalActivity : AppCompatActivity() {

    val appComponent: AppComponent by lazy(mode = LazyThreadSafetyMode.NONE) {
        (application as App).appComponent
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                finish()
            }
            else -> return true
        }
        return true
    }
}

