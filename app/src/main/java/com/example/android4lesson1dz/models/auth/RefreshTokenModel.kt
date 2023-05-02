package com.example.android4lesson1dz.models.auth

import com.google.gson.annotations.SerializedName

data class RefreshTokenModel(
    @SerializedName("refresh_token")
    val refreshToken: String = "",
    @SerializedName("access_token")
    val accessToken: String,
)