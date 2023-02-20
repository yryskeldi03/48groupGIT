package com.yrys.mykotlin5group48lesson1.presentation.ui

sealed class UIState<T> {

    class Success<T>(val data: T) : UIState<T>()
    class Loading<T> : UIState<T>()
    class Error<T>(val message: String) : UIState<T>()
    class Empty<T> : UIState<T>()

}