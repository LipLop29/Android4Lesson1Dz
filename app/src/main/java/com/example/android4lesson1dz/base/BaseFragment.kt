package com.example.android4lesson1dz.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.lifecycleScope
import androidx.viewbinding.ViewBinding
import com.example.android4lesson1dz.utils.Resource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding, VM : ViewModel>(
    @LayoutRes layoutId: Int
) : Fragment(layoutId) {

    abstract val binding: VB
    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initialize()
        setupListener()
        setupObserves()
        setupSubscribes()
    }

    protected open fun setupSubscribes() {}

    protected open fun initialize() {}

    protected open fun setupListener() {}

    protected open fun setupObserves() {}

    protected open fun <T> Flow<Resource<T>>.subscribe(
        state: ((state: Resource<T>) -> Unit)? = null,
        onError: (error: String) -> Unit,
        onSuccess: ((data: T) -> Unit)
    ) {
        lifecycleScope.launch {
            collect {
                when (it) {
                    is Resource.Error -> onError(it.massage.toString())
                    is Resource.Loading -> {}
                    is Resource.Success -> {
                        it.data?.let { data ->
                            onSuccess(data)
                        }
                    }
                }
            }
        }
    }
}