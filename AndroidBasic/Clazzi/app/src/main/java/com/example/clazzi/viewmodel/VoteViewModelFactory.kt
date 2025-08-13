package com.example.clazzi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clazzi.repository.VoteRepository

class VoteViewModelFactory(
    val repository: VoteRepository
)  : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if(modelClass.isAssignableFrom(VoteViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return VoteViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}