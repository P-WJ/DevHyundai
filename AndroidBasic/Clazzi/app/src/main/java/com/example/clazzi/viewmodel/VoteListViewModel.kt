package com.example.clazzi.viewmodel

import android.content.Context
import android.net.Uri
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clazzi.model.Vote
import com.example.clazzi.repository.FirebaseVoteRepository
import com.example.clazzi.repository.VoteRepository
import com.google.firebase.Firebase
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch


class VoteListViewModel(repository: VoteRepository) : ViewModel() {
    val db = Firebase.firestore
    private val _voteList = MutableStateFlow<List<Vote>>(emptyList())
    val voteList: StateFlow<List<Vote>> = _voteList

    val voteRepository: VoteRepository = repository

    init {
        // 뷰모델 초기화 시 실시간 리스너 설정
//        db.collection("votes")
//            .orderBy("createAt", Query.Direction.DESCENDING)
//            .addSnapshotListener { snapshot, error ->
//                if(error != null) {
//                    Log.e("FireStore", "Error getting votes", error)
//                    return@addSnapshotListener
//                }
//                if (snapshot != null) {
//                    _voteList.value = snapshot.toObjects(Vote::class.java)
//                }
//            }

        viewModelScope.launch {
            voteRepository.observeVotes().collect { votes ->
                _voteList.value = votes;
            }
        }
    }

//    init {
//        _voteList.value = listOf (
//            Vote(
//                id = "1", title = "오늘 점심 뭐 먹을까요?", voteOptions = listOf(
//                    VoteOption(id = "1", optionText = "삼겹살"),
//                    VoteOption(id = "2", optionText = "치킨"),
//                    VoteOption(id = "3", optionText = "피자"),
//                )
//            ), Vote(
//                id = "2", title = "우리 반에서 제일 잘생긴 사람은??", voteOptions = listOf(
//                    VoteOption(id = "1", optionText = "김한수"),
//                    VoteOption(id = "2", optionText = "박명수"),
//                    VoteOption(id = "3", optionText = "유재석"),
//                )
//            ), Vote(
//                id = "3", title = "서핑 같이 가고 싶은 사람은?", voteOptions = listOf(
//                    VoteOption(id = "1", optionText = "정준하"),
//                    VoteOption(id = "2", optionText = "하하"),
//                )
//            )
//        )
//    }

    //ID로 특정 투표를 가져오는 메서드
    fun getVoteById(voteId: String): Vote? {
        return _voteList.value.find { it.id == voteId }
    }

    // 새로운 투표를 추가하는 메서드
    fun addVote(vote: Vote, context: Context, imageUri: Uri) {
//        _voteList.value += vote
        viewModelScope.launch {
            voteRepository.addVote(vote,context,imageUri)
        }
    }

    fun setVote(vote: Vote) {
        viewModelScope.launch {
            voteRepository.setVote(vote)

        }
    }
}