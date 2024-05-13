package com.example.anorbank.di

import com.example.anorbank.presentation.auth.finger.FingerDirection
import com.example.anorbank.presentation.auth.finger.FingerDirectionImpl
import com.example.anorbank.presentation.auth.keyword.KeywordDirection
import com.example.anorbank.presentation.auth.keyword.KeywordDirectionImpl
import com.example.anorbank.presentation.auth.language.LanguageDirection
import com.example.anorbank.presentation.auth.language.LanguageDirectionImpl
import com.example.anorbank.presentation.auth.register.phone.AuthDirection
import com.example.anorbank.presentation.auth.register.phone.AuthDirectionImpl
import com.example.anorbank.presentation.auth.register.reg.RegDirection
import com.example.anorbank.presentation.auth.register.reg.RegDirectionImpl
import com.example.anorbank.presentation.auth.verify.SmsDirection
import com.example.anorbank.presentation.auth.verify.SmsDirectionImpl
import com.example.anorbank.presentation.splash.SplashDirection
import com.example.anorbank.presentation.splash.SplashDirectionImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
interface DirectionModule {
@Binds
fun splashDirection(impl: SplashDirectionImpl): SplashDirection

@Binds
fun languageDir(impl: LanguageDirectionImpl): LanguageDirection

@Binds
    fun authPhoneDir(impl: AuthDirectionImpl ): AuthDirection

@Binds
fun regDirection(impl: RegDirectionImpl): RegDirection

@Binds
fun smsCodeDir(impl: SmsDirectionImpl): SmsDirection

@Binds
fun fingerDir(impl: FingerDirectionImpl): FingerDirection

@Binds
fun keywordDir(impl: KeywordDirectionImpl): KeywordDirection


}