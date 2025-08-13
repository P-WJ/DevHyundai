package com.example.clazzi.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.clazzi.repository.VoteRepository

class VoteListViewModelFactory(
    val repository: VoteRepository
)  : ViewModelProvider.Factory{
    override fun <T : ViewModel> create(
        modelClass: Class<T>
    ): T {
        if(modelClass.isAssignableFrom(VoteListViewModel::class.java)){
            @Suppress("UNCHECKED_CAST")
            return VoteListViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}