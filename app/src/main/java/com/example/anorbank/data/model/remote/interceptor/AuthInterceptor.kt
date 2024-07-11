//package com.example.anorbank.data.model.remote.interceptor
//
//import android.annotation.SuppressLint
//import android.util.Log
//import com.example.anorbank.data.source.local.MyPreference
//import com.example.anorbank.data.source.remote.MyApi
//import kotlinx.coroutines.runBlocking
//import okhttp3.Interceptor
//import okhttp3.Response
//import retrofit2.Retrofit
//import retrofit2.converter.gson.GsonConverterFactory
//import javax.inject.Inject
//
//class AuthInterceptor @Inject constructor(private val shared: MyPreference) :
//    Interceptor {
//    private val retrofit = Retrofit.Builder()
//        .baseUrl("http://195.158.16.140/mobile-bank/v1/")
//        .addConverterFactory(GsonConverterFactory.create())
//        .build()
//    private val refreshApi = retrofit.create(MyApi::class.java)
//    override fun intercept(chain: Interceptor.Chain): Response {
//        val originalRequest = chain.request()
//        val response = chain.proceed(originalRequest)
//        val accessToken = shared.getAccessToken()
//        if (response.code == 401) {
//            runBlocking {
//                response.close()
//                val newRefreshedAccessToken = refreshToken()
//                run {
//                    val newest = shared.getAccessToken()
//                    val newRequest = originalRequest.newBuilder()
//                        .addHeader("Authorization", "Bearer $newest")
//                        .build()
//                    //  shared.saveAccessToken(newRefreshedAccessToken)
//                    return@runBlocking chain.proceed(newRequest)
//                }
//            }
//        }
//        return response
//    }
//
//    @SuppressLint("SuspiciousIndentation")
//    private suspend fun refreshToken(): String {
//        val refreshToken = shared.getRefreshToken()
//        Log.d("XX", "REFRESH FUN IS WORKING ")
//        if (refreshToken.isNotEmpty()) {
//            Log.d("XX", "REFRESH FUN IF BLOCK")
//            val responseUpdatedToken = refreshApi.updateToken(refreshToken)
//            val ss = responseUpdatedToken.body()!!.accessToken
//            shared.saveAccessToken(ss)
//            Log.d("XX", "REFRESH FUN RETURN NEW ACCESS TOKEN ")
//            return ss
//        } else
//            throw Exception("Missing refresh token")
//    }
//}
//
//////        if (accessToken != null && accessToken.isNotEmpty()) {
//////            val newNotUpdated = originalRequest.newBuilder()
//////                .header("Authorization", "Bearer $accessToken")
//////                .build()
//////            Log.d("KK", "seeee1111: ")
//////            return chain.proceed(newNotUpdated)
//////        }
