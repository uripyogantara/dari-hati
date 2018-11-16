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

    var name = sharedPreferences.getString(KEY_NAME, "")
        set(value) = sharedPreferences.edit().putString(KEY_NAME,value).apply()

    var email = sharedPreferences.getString(KEY_EMAIL, "")
        set(value) = sharedPreferences.edit().putString(KEY_EMAIL,value).apply()

    var address = sharedPreferences.getString(KEY_ADDRESS, "")
        set(value) = sharedPreferences.edit().putString(KEY_ADDRESS,value).apply()

    var phone = sharedPreferences.getString(KEY_PHONE, "")
        set(value) = sharedPreferences.edit().putString(KEY_PHONE,value).apply()

    var identity = sharedPreferences.getString(KEY_IDENTITY, "")
        set(value) = sharedPreferences.edit().putString(KEY_IDENTITY,value).apply()
}