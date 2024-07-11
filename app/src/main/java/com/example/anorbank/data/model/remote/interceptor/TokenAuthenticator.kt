package com.example.anorbank.data.model.remote.interceptor

import android.annotation.SuppressLint
import android.content.Context
import com.chuckerteam.chucker.api.ChuckerInterceptor
import com.example.anorbank.data.source.local.MyPreference
import com.example.anorbank.data.source.local.db.RequestTokenAuth
import com.example.anorbank.data.source.remote.MyApi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.runBlocking
import okhttp3.Authenticator
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.Route
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Inject

class TokenAuthenticator @Inject constructor(@ApplicationContext context: Context,private val shared: MyPreference) : Authenticator {

    private val retrofit = Retrofit.Builder()
        .baseUrl("http://195.158.16.140/mobile-bank/")
        .addConverterFactory(GsonConverterFactory.create())
        .client(
            OkHttpClient
                .Builder()
                .addInterceptor(ChuckerInterceptor(context = context))
                .build()
        )
        .build()
    private val refreshApi = retrofit.create(MyApi::class.java)

    @SuppressLint("LogNotTimber")
    override fun authenticate(route: Route?, response: Response): Request? {


        return runBlocking {
            val responseRefresh = refreshApi.updateToken(
                RequestTokenAuth(shared.getRefreshToken())
            )

            if (responseRefresh.isSuccessful && responseRefresh.code() == 200) {
                val data = responseRefresh.body()!!
                shared.saveAccessToken(data.accessToken)
                shared.saveRefreshToken(data.refreshToken)
                return@runBlocking response.request.newBuilder()
                    .removeHeader("Authorization")
                    .addHeader(
                        "Authorization",
                        "Bearer ${shared.getAccessToken()}"
                    )
                    .build()
            } else null
        }
    }







//    private val retrofit = Retrofit.Builder()
//        .baseUrl("http://195.158.16.140/mobile-bank/v1/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .client(
//            OkHttpClient
//                .Builder()
//                .addInterceptor(ChuckerInterceptor(context = context))
//                .build()
//        ).build()
//    private val refreshApi = retrofit.create(MyApi::class.java)
//    override fun authenticate(route: Route?, response: Response): Request? {
//        return runBlocking {
//            val responseRefresh = refreshApi.updateToken(RequestTokenAuth(shared.getRefreshToken()))
//
//            if (responseRefresh.isSuccessful && responseRefresh.code() == 200) {
//                val data = responseRefresh.body()!!
//                shared.saveAccessToken(data.accessToken)
//                shared.saveRefreshToken(data.refreshToken)
//
//                return@runBlocking response.request.newBuilder()
//                    .removeHeader("Authorization")
//                    .header("Authorization", "Bearer ${shared.getAccessToken()}")
//                    .build()
//            } else null
//        }
//    }
}