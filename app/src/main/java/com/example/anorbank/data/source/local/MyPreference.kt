package com.example.anorbank.data.source.local

import android.content.SharedPreferences
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class MyPreference @Inject constructor(private val sharedPreference: SharedPreferences) {


    //auth token
    fun saveToken(token: String): Unit = sharedPreference.edit()
        .putString("TOKEN", token).apply()


    fun getToken(): String = sharedPreference.getString("TOKEN", "LOGIN")!!


    // access token
    fun saveAccessToken(token: String): Unit = sharedPreference.edit()
        .putString("ACCESS", token).apply()


    fun getAccessToken(): String = sharedPreference.getString("ACCESS", null)!!


    // refresh token

    fun saveRefreshToken(token: String): Unit = sharedPreference.edit()
        .putString("REFRESH", token).apply()


    fun getRefreshToken(): String = sharedPreference.getString("REFRESH", null)!!

    // pin

    fun savePinCode(pin: String) = sharedPreference.edit().putString("PIN", pin).apply()

    fun getPin (): String = sharedPreference.getString("PIN", null)!!









    fun saveLanguage(selectedLanguage: String) {
        sharedPreference.edit().putString("LANG", selectedLanguage).apply()
    }

    fun getSelectedLanguage(): String = sharedPreference.getString("LANG", null)!!
}