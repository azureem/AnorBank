package com.example.anorbank.utils.navigator

import cafe.adriel.voyager.core.screen.Screen

typealias AppScreen = Screen

interface AppNavigator {
   // suspend fun stackLog()

    suspend fun back()
    suspend fun backUntilRoot()
    suspend fun backAll()
    suspend fun navigateTo(screen: AppScreen)
    suspend fun replace(screen: AppScreen)
    suspend fun replaceAll(screen: AppScreen)
}