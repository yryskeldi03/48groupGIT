package com.yrys.mykotlin5group48lesson1.presentation.base

import android.os.Bundle
import android.view.View
import androidx.annotation.LayoutRes
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import com.yrys.mykotlin5group48lesson1.presentation.ui.UIState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment(@LayoutRes layoutId: Int) : Fragment(layoutId) {

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        initialize()
        setupRequests()
        setupListeners()
        setupSubscribers()
    }

    protected open fun initialize() {}

    protected open fun setupRequests() {}

    protected open fun setupSubscribers() {}

    protected open fun setupListeners() {}

    protected fun <T> StateFlow<UIState<T>>.collectState(
        onLoading: () -> Unit,
        onError: (message: String) -> Unit,
        onSuccess: (data: T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect {
                    when (it) {
                        is UIState.Empty -> {}
                        is UIState.Error -> {
                            onError(it.message)
                        }
                        is UIState.Loading -> {
                            onLoading()
                        }
                        is UIState.Success -> {
                            onSuccess(it.data)
                        }
                    }
                }
            }
        }
    }

}