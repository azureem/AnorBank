package com.example.anorbank.data.model.remote.request

import com.google.gson.annotations.SerializedName

data class OtpRequest (
    @SerializedName ("token")val token: String,
    @SerializedName ("code") val smsCode: String
)