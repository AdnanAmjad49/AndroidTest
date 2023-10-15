package com.comcast.androidtest.data


sealed class UIState {
    data class Loading(val isShow: Boolean) : UIState()
    data class Error(val message: String) : UIState()
    data class Data(val data: List<AnimalUI>) : UIState()
}