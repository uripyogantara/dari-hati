package id.futnet.darihati.utils

import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager

class PreferencesHelper(private val context: Context) {
    private val NAME="shared_preferences"
    private val KEY_LOGIN="login"
    private val KEY_NAME="name"
    private val KEY_TOKEN="token"
    private val KEY_EMAIL="email"
    private val KEY_ADDRESS="address"
    private val KEY_PHONE="phone"
    private val KEY_IDENTITY="identity"


    private val sharedPreferences=PreferenceManager.getDefaultSharedPreferences(context)

    var token = sharedPreferences.getString(KEY_TOKEN, "")
        set(value) = sharedPreferences.edit().putString(KEY_TOKEN,value).apply()

    var login=sharedPreferences.getBoolean(KEY_LOGIN,false)
        set(value) = sharedPreferences.edit().putBoolean(KEY_LOGIN,value).apply()

}