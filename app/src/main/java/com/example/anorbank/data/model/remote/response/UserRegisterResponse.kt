package com.example.anorbank.data.model.remote.response

data class UserRegisterResponse (
    val token: String,
    val smsCode: String
)