package com.example.voterestapiandroid

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.gson.Gson
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.asRequestBody
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.File

class VoteViewModel : ViewModel() {
    var votes by mutableStateOf(emptyList<Vote>())

    var vote by mutableStateOf<Vote?>(null)

    fun fetchVotes() {
        viewModelScope.launch {
            votes = RetrofitClient.voteApiService.getVotes()
        }
    }

    fun fetchVoteById(id: Int) {
        viewModelScope.launch {
            vote = RetrofitClient.voteApiService.getVote(id)
        }
    }

//    fun createVote(title: String, description: String) {
//        viewModelScope.launch {
//            val newVote = Vote(title = title, description = description)
//            val createdVote = RetrofitClient.voteApiService.createVote(newVote)
//            votes = votes + createdVote
//        }
//    }

    fun createVote(title: String, description: String, imageFile: File?) {
        viewModelScope.launch {
            val newVote = Vote(title = title, description = description)
            val voteJson = Gson().toJson(newVote)
            val voteBody = voteJson.toRequestBody("application/json".toMediaTypeOrNull())
            val imagePart = imageFile?.let {
                MultipartBody.Part.createFormData(
                    "image",
                    it.name,
                    it.asRequestBody("image/*".toMediaTypeOrNull())
                )
            }
            val createdVote = RetrofitClient.voteApiService.createVote(voteBody, imagePart)
            votes = votes + createdVote
        }
    }
}