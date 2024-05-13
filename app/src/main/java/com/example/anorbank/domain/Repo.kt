package com.example.anorbank.domain

import com.example.anorbank.data.model.remote.StartScreenEnum
import com.example.anorbank.data.model.remote.request.OtpRequest
import com.example.anorbank.data.model.remote.request.UpdateTokenRequest
import com.example.anorbank.data.model.remote.request.UserLoginRequest
import com.example.anorbank.data.model.remote.request.UserRegisterRequest
import com.example.anorbank.data.model.remote.response.OtpResponseToken
import com.example.anorbank.data.model.remote.response.UserLoginResponse
import com.example.anorbank.data.model.remote.response.UserRegisterResponse
import kotlinx.coroutines.flow.Flow


interface Repo {

    fun startScreen(): StartScreenEnum
    fun saveSelectedLanguage(lang: String)
    fun registration(data: UserRegisterRequest): Flow<Result<UserRegisterResponse>>
    fun login(data: UserLoginRequest): Flow<Result<UserLoginResponse>>
    fun saveToken (token: String)
    fun otpVerifySignUp(otp: OtpRequest) : Flow<Result<OtpResponseToken>>
    fun otpVerifySignIn(otp: OtpRequest) : Flow<Result<OtpResponseToken>>
    fun updateToken(updateToken: String) : Flow<Result<OtpResponseToken>>
}