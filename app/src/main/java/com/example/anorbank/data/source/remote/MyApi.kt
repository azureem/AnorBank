package com.example.anorbank.data.source.remote

import com.example.anorbank.data.model.remote.request.OtpRequest
import com.example.anorbank.data.model.remote.request.UserLoginRequest
import com.example.anorbank.data.model.remote.request.UserRegisterRequest
import com.example.anorbank.data.model.remote.response.OtpResponseToken
import com.example.anorbank.data.model.remote.response.UserLoginResponse
import com.example.anorbank.data.model.remote.response.UserRegisterResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface MyApi {

    //AUTHENTICATION
    @POST("v1/auth/sign-up")
    suspend fun registerUser(@Body userData: UserRegisterRequest): Response<UserRegisterResponse>

    @POST("v1/auth/sign-in")
    suspend fun login(@Body userData: UserLoginRequest): Response<UserLoginResponse>

    @POST("v1/auth/sign-up/verify")
    suspend fun otpVerifySignUp(@Body otpData: OtpRequest): Response<OtpResponseToken>

    @POST("v1/auth/sign-in/verify")
    suspend fun otpVerifySignIn(@Body otpData: OtpRequest): Response<OtpResponseToken>

    @POST("v1/auth/update-token")
    suspend fun updateToken(@Body updateToken: String): Response<OtpResponseToken>

    @POST("v1/auth/sign-up/resend")
    suspend fun upResend(@Body expiredToken: String): Response<String>

    @POST("v1/auth/sign-in/resend")
    suspend fun inResend(@Body expiredToken: String): Response<String>

    @POST("v1/auth/sign-out")
    suspend fun signOut(): Response<String>


    //CARD

}