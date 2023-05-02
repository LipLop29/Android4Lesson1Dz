package com.example.android4lesson1dz.data.remote.apiserveces

import com.example.android4lesson1dz.models.auth.AccessTokenModel
import com.example.android4lesson1dz.models.auth.RefreshTokenModel
import retrofit2.http.Body
import retrofit2.http.POST

interface SignInApiService {

    @POST("oauth/token")
    suspend fun fetchSignIn(
        @Body accessTokenModel : AccessTokenModel
    ) : RefreshTokenModel
}