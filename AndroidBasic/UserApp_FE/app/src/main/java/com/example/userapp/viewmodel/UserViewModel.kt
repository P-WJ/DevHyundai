package com.example.userapp.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.userapp.model.User
import com.example.userapp.repository.UserRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: UserRepository = UserRepository()
) : ViewModel() {

    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> = _users

    private val _selectedUser = MutableStateFlow<User?>(null)
    val selectedUser: StateFlow<User?> = _selectedUser

    fun loadUsers() {
        viewModelScope.launch {
            _users.value = repository.getUsers()
        }
    }

    fun getUser(id: Long) {
        viewModelScope.launch {
            _selectedUser.value = repository.getUser(id)
        }
    }

    fun addUser(name: String, email: String) {
        viewModelScope.launch {
            val newUser = User(name = name, email = email)
            repository.createUser(newUser)
            loadUsers()
        }
    }

    fun updateUser(id: Long, name: String, email: String) {
        viewModelScope.launch {
            repository.updateUser(id, User(id, name, email))
            loadUsers()
        }
    }

    fun deleteUser(id: Long) {
        viewModelScope.launch {
            repository.deleteUser(id)
            loadUsers()
        }
    }

}