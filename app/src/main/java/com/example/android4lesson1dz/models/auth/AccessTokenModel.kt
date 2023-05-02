package com.example.android4lesson1dz.models.auth

import com.google.gson.annotations.SerializedName

data class AccessTokenModel(
    @SerializedName("password")
    val password: String,
    @SerializedName("grant_type")
    val grantType: String = "password",
    @SerializedName("username")
    val username: String
)