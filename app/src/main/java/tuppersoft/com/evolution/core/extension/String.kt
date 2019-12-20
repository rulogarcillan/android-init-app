package tuppersoft.com.evolution.core.extension

import android.util.Log
import tuppersoft.com.evolution.BuildConfig
import tuppersoft.com.evolution.core.platform.TAG

fun String?.log(tag: String = TAG) {
    if (BuildConfig.DEBUG) {
        Log.d(tag, this ?: "************** - Null value - **************")
    }
}
/*
inline fun <reified T : Any> String.jsonToClass(): T {
    val gson = Gson()
    return gson.fromJson(this, T::class.java)
}
*/

