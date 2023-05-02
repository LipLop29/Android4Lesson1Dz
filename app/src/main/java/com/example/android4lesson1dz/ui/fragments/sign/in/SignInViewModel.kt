package com.example.android4lesson1dz.ui.fragments.sign.`in`

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.android4lesson1dz.utils.Resource
import com.example.android4lesson1dz.base.BaseViewModel
import com.example.android4lesson1dz.data.repositories.SignInRepository
import com.example.android4lesson1dz.models.auth.AccessTokenModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SignInViewModel @Inject constructor(
    private val repository: SignInRepository
) : BaseViewModel() {

    fun fetchSignIn(accessModel: AccessTokenModel) = repository.fetchSignIn(accessModel)
}