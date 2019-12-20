@file:Suppress("UNCHECKED_CAST")

package tuppersoft.com.data.repositories

import android.content.Context
import androidx.preference.PreferenceManager

object SharedPreferencesRepository {

    /**
     * Guarda cualquier valor primitivo en el shared preferences
     */
    inline fun <reified T> savePreference(mContext: Context, key: String, value: T) {

        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext)
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
    inline fun <reified T : Any> loadPreference(mContext: Context, key: String, defaultValue: T): T {
        val sharedPreferences = PreferenceManager.getDefaultSharedPreferences(mContext)
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
    fun removePreference(context: Context, key: String) {
        val mySPrefs = PreferenceManager.getDefaultSharedPreferences(context)
        val editor = mySPrefs.edit()
        if (mySPrefs.contains(key)) {
            editor.remove(key)
            editor.apply()
        }
    }
}