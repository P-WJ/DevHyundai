package com.wj.mvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.wj.mvvm.model.User
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class UserViewModel : ViewModel() {
    private val _user = MutableStateFlow<User>(User(name = "박우진"))
    val user: StateFlow<User> = _user.asStateFlow()

    fun changeName(name: String) {
        _user.value = User(name = name)
    }
}