package com.example.android4lesson1dz.ui.fragments.sign.`in`

import android.util.Log
import androidx.fragment.app.viewModels
import androidx.navigation.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.android4lesson1dz.R
import com.example.android4lesson1dz.base.BaseFragment
import com.example.android4lesson1dz.data.local.preferences.PreferencesHelper
import com.example.android4lesson1dz.data.local.preferences.UserPreferencesData
import com.example.android4lesson1dz.databinding.FragmentSignInBinding
import com.example.android4lesson1dz.models.auth.AccessTokenModel
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SignInFragment :
    BaseFragment<FragmentSignInBinding, SignInViewModel>(R.layout.fragment_sign_in) {

    @Inject
    lateinit var userPreferencesData: UserPreferencesData
    override val binding by viewBinding(FragmentSignInBinding::bind)
    override val viewModel: SignInViewModel by viewModels()

    @Inject
    lateinit var preferencesHelper: PreferencesHelper

    override fun setupListener() {
        subscribeToSignIn()
    }

    private fun subscribeToSignIn() = with(binding) {

        btnInput.setOnClickListener {

            val email = inputLayoutEmail.text.toString()
            val password = inputLayoutPsw.text.toString()
            val accessModel = AccessTokenModel(password, "password", email)

            viewModel.fetchSignIn(accessModel).subscribe(
                onError = {
                    Log.e("TAG", "setupSubscribes: $it")
                },
                onSuccess = {
                    if (it != null) {
                        userPreferencesData.apply {
                            isAuthorized = true
                            accessToken = it.accessToken
                            refreshToken = it.refreshToken
                        }
                        requireActivity().findNavController(R.id.my_nav_host_fragment)
                            .navigate(R.id.action_signFlowFragment_to_homeFlowFragment)
                    }
                }
            )
        }
    }
}
