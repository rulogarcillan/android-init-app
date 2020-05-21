@file:Suppress("UNCHECKED_CAST")

package tuppersoft.com.data.repositories

import android.content.Context
import androidx.preference.PreferenceManager

object SharedPreferencesRepository {

    /**
     * Guarda cualquier valor primitivo en el shared preferences
     */
    inline fun <reified T> Context.savePreference(key: String, value: T) {

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = sharedPreferences.edit()

        when (value) {
            is Boolean -> editor.putBoolean(key, value)
            is Float -> editor.putFloat(key, value)
            is Int -> editor.putInt(key, value)
            is Long -> editor.putLong(key, value)
            is String -> editor.putString(key, value)
            else -> return
        }
        editor.apply()
    }

    /**
     * Carga cualquier valor primitivo del shared preferences
     */
    inline fun <reified T : Any> Context.loadPreference(key: String, defaultValue: T): T {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        return when (defaultValue) {
            is Boolean -> sharedPreferences.getBoolean(key, defaultValue) as T
            is Float -> sharedPreferences.getFloat(key, defaultValue) as T
            is Int -> sharedPreferences.getInt(key, defaultValue) as T
            is Long -> sharedPreferences.getLong(key, defaultValue) as T
            is String -> sharedPreferences.getString(key, defaultValue) as T
            else -> defaultValue
        }
    }

    /**
     * Elimina la shared preference para la key dada
     */
    fun Context.removePreference(key: String) {
        val mySPrefs = PreferenceManager.getDefaultSharedPreferences(this)
        val editor = mySPrefs.edit()
        if (mySPrefs.contains(key)) {
            editor.remove(key)
            editor.apply()
        }
    }
}