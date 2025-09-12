package com.example.androidcomposetdd.viewmodel

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel

import jakarta.inject.Inject

@HiltViewModel
class TextViewModel @Inject constructor() : ViewModel() { // 생성자에 @Inject 추가
    var displayText by mutableStateOf("")
        private set // 세터만 프라이빗으로 : 외부에서 직접 설정 못 하게.

    fun updateText(text: String) {
        displayText = text
    }
}