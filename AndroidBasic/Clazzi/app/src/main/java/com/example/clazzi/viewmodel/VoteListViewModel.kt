package com.example.clazzi.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.clazzi.model.Vote
import com.example.clazzi.model.VoteOption
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import com.google.firebase.Firebase
import com.google.firebase.firestore.FieldValue
import com.google.firebase.firestore.firestore
import kotlinx.coroutines.tasks.await

class VoteListViewModel : ViewModel() {
    val db = Firebase.firestore
    private val _voteList = MutableStateFlow<List<Vote>>(emptyList())
    val voteList: StateFlow<List<Vote>> = _voteList


    init {
        // 뷰 모델 초기화 시 실시간 리스너 설정
        db.collection("votes")
            .addSnapshotListener {snapshot, error ->
                if (error != null) {
                    Log.e("Firestore", "Error getting votes", error)
                    return@addSnapshotListener
                }
                if (snapshot != null) {
                    _voteList.value = snapshot.toObjects(Vote::class.java)
                }
            }
    }

//    init {
//        _voteList.value = listOf(
//            Vote(
//                "1", "오늘 아침 뭐먹을 까요", voteOptions = listOf(
//                    VoteOption("1", "달걀"),
//                    VoteOption("2", "오유"),
//                    VoteOption("3", "맥모닝"),
//                )
//            ),
//            Vote(
//                "2", "오늘 점심 뭐먹을 까요", voteOptions = listOf(
//                    VoteOption("1", "삼겹살"),
//                    VoteOption("2", "치킨"),
//                    VoteOption("3", "피자"),
//                )
//            ), Vote(
//                "3", "오늘 저녁 뭐먹을 까요", voteOptions = listOf(
//                    VoteOption("1", "소주"),
//                    VoteOption("2", "양주"),
//                    VoteOption("3", "맥주"),
//                )
//            )
//        )
//    }

    // ID로 특정 투표를 가져오는 메서드
    fun getVoteById(voteId: String): Vote? {
        return _voteList.value.find { it.id == voteId }
    }

    // 새로운 투표를 추가하는 메서드
    fun addVote(vote: Vote) {
//        _voteList.value += vote
        val db = Firebase.firestore
        viewModelScope.launch {
            try {
                val voteMap = hashMapOf(
                    "id" to vote.id,
                    "title" to vote.title,
                    "createAt" to FieldValue.serverTimestamp(),  // 서버 타입 설정
                    "voteOptions" to vote.voteOptions.map {
                        hashMapOf(
                            "id" to it.id,
                            "optionText" to it.optionText
                        )
                    }
                )
                db.collection("votes")
                    .document(vote.id)
                    .set(voteMap)  // Map으로 저장
                    .await()
            } catch (e: Exception) {
                // 에러 처리 (예: 사용자에게 토스트 메시지 표시)
            }
        }
    }

    // 투표 데이터를 업데이트 하는 함수
    fun setVote(vote: Vote) {
        viewModelScope.launch {
            try {
                db.collection("votes")
                    .document(vote.id)
                    .set(vote)
                    .await()
                Log.d("Firestore", "투표가 성공적으로 되었습니다.")
            } catch (e: Exception) {
                Log.e("Firestore", "투표 업데이트 중 오류가 발생했습니다.", e)
            }
        }
    }
}
