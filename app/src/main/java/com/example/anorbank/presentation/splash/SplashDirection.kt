package com.example.anorbank.presentation.splash

import com.example.anorbank.presentation.auth.language.LanguageScreen
import com.example.anorbank.utils.navigator.AppNavigator
import javax.inject.Inject
import javax.inject.Singleton

interface SplashDirection {
    suspend fun next()


}

@Singleton
class SplashDirectionImpl @Inject constructor(
    private val  appNavigator: AppNavigator):
    SplashDirection{
    override suspend fun next() {
        appNavigator.replace(LanguageScreen())
    }

}