package com.example.anorbank.domain.impl

import com.example.anorbank.data.model.remote.StartScreenEnum
import com.example.anorbank.data.model.remote.request.OtpRequest
import com.example.anorbank.data.model.remote.request.UserLoginRequest
import com.example.anorbank.data.model.remote.request.UserRegisterRequest
import com.example.anorbank.data.model.remote.response.OtpResponseToken
import com.example.anorbank.data.model.remote.response.UserLoginResponse
import com.example.anorbank.data.model.remote.response.UserRegisterResponse
import com.example.anorbank.data.source.local.MyPreference
import com.example.anorbank.data.source.remote.MyApi
import com.example.anorbank.domain.Repo
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepoImpl @Inject constructor(
    private val shared: MyPreference,
    private val api: MyApi
) : Repo {


    override fun startScreen(): StartScreenEnum {
        return when (shared.getToken()) {
            "LOGIN" -> StartScreenEnum.Login
            else -> StartScreenEnum.Main
        }
    }

    override fun saveSelectedLanguage(lang: String) {
        
    }

    override fun registration(data: UserRegisterRequest): Flow<Result<UserRegisterResponse>> =
        callbackFlow {
            val response = api.registerUser(data)
            if (response.isSuccessful && response.body() != null) {
                val comingToken = response.body()!!.token
                saveToken(comingToken)
                trySend(Result.success(response.body()!!))
            } else trySend(Result.failure(Exception("Fail, your data couldn't registered!")))

            awaitClose()
        }


    override fun login(data: UserLoginRequest): Flow<Result<UserLoginResponse>> = callbackFlow {
        val response = api.login(data)
        if (response.isSuccessful && response.body() != null) {
            val comingToken = response.body()!!.token
            saveToken(comingToken)
            trySend(Result.success(response.body()!!))
        } else trySend(Result.failure(Exception("Failed, this user has not been registered")))

        awaitClose()
    }

    override fun saveToken(token: String) {
        shared.saveToken(token)
    }

    override fun otpVerifySignUp(otp: OtpRequest): Flow<Result<OtpResponseToken>> = callbackFlow {
        val response = api.otpVerifySignUp(otp)
        if (response.isSuccessful && response.body() != null) {
            val access = response.body()!!.accessToken
            val refresh = response.body()!!.refreshToken
            shared.saveAccessToken(access)
            shared.saveRefreshToken(refresh)
            trySend(Result.success(response.body()!!))
        } else {
            trySend(Result.failure(Exception("Something went wrong!")))
        }
        awaitClose()
    }

    override fun otpVerifySignIn(otp: OtpRequest): Flow<Result<OtpResponseToken>> = callbackFlow{
        val response = api.otpVerifySignIn(otp)
        if (response.isSuccessful && response.body() != null) {
            val access = response.body()!!.accessToken
            val refresh = response.body()!!.refreshToken
            shared.saveAccessToken(access)
            shared.saveRefreshToken(refresh)
            trySend(Result.success(response.body()!!))
        } else {
            trySend(Result.failure(Exception("Something went wrong!")))
        }
        awaitClose()
    }

    override fun updateToken(updateToken: String): Flow<Result<OtpResponseToken>> = callbackFlow {
        val update = shared.getRefreshToken()
        val response = api.updateToken(update)
        if (response.isSuccessful && response.body() != null) {
            val access = response.body()!!.accessToken
            val refresh = response.body()!!.refreshToken
            shared.saveAccessToken(access)
            shared.saveRefreshToken(refresh)
            trySend(Result.success(response.body()!!))
        } else {
            trySend(Result.failure(Exception("Something, went wrong!")))
        }
        awaitClose()
    }
}