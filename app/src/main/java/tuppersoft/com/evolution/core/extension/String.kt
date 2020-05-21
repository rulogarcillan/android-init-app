package tuppersoft.com.evolution.core.extension

import android.util.Log
import androidx.databinding.library.BuildConfig
import tuppersoft.com.evolution.core.platform.TAG

fun String?.log(tag: String = TAG) {
    if (BuildConfig.DEBUG) {
        Log.d(tag, this ?: "************** - Null value - **************")
    }
}


