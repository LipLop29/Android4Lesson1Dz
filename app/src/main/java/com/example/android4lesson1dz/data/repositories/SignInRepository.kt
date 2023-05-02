package com.example.android4lesson1dz.data.repositories

import com.example.android4lesson1dz.base.BaseRepository
import com.example.android4lesson1dz.data.remote.apiserveces.SignInApiService
import com.example.android4lesson1dz.models.auth.AccessTokenModel
import javax.inject.Inject

class SignInRepository @Inject constructor(
    private val service : SignInApiService
): BaseRepository() {

    fun fetchSignIn(accessModel: AccessTokenModel) = doRequest {
        service.fetchSignIn(accessModel)
    }
}