package com.example.clazzi.repository

import android.content.Context
import android.net.Uri
import android.util.Log
import com.example.clazzi.model.Vote
import com.google.firebase.Firebase
import com.google.firebase.firestore.Query
import com.google.firebase.firestore.firestore
import com.google.firebase.storage.FirebaseStorage
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.tasks.await
import java.util.UUID

class FirebaseVoteRepository : VoteRepository {

    val db = Firebase.firestore
    override fun observeVotes(): Flow<List<Vote>> = callbackFlow {
        // 뷰모델 초기화 시 실시간 리스너 설정
        val listener = db.collection("votes")
            .orderBy("createAt", Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, error ->
                if(error != null) {
                    Log.e("FireStore", "Error getting votes", error)
                    // 에러가 있으면 구독을 취소해버린다.
                    close(error)
                }else if(snapshot != null){
                    val votes = snapshot.toObjects(Vote::class.java)
                    trySend(votes)
                }
            }
        awaitClose { listener.remove() }
    }

    override suspend fun addVote(
        vote: Vote,
        context: Context,
        imageUri: Uri
    ) {
        try {
            val storageRef = FirebaseStorage.getInstance().reference
            val imageRef = storageRef.child("images/${UUID.randomUUID()}.jpg")

            // 이미지 업로드
            val inputStream = context.contentResolver.openInputStream(imageUri)
            val uploadTask = inputStream?.let {imageRef.putStream(it).await()}

            // 다운로드 URL 가져오기
            val downloadUrl = imageRef.downloadUrl.await().toString()

            // Firestore에 업로드할 데이터 구성
            val voteMap = hashMapOf(
                "id" to vote.id,
                "title" to vote.title,
                "imageUrl" to downloadUrl, // 이미지 URL 추가
                "createAt" to vote.createAt, // 서버 타임으로 설정 "createAt" to FieldValue.serverTimestamp(),
                "voteOptions" to vote.voteOptions.map {
                    hashMapOf(
                        "id" to it.id,
                        "optionText" to it.optionText,
                    )
                },
                "deadline" to vote.deadline
            )

            // Firestore에 저장
            db.collection("votes")
                .document(vote.id)
                .set(voteMap)
                .await()
        } catch (e: Exception) {}
    }

    // suspend : 비동기함수의 네트워크 통신에서 유용하게 사용
    // 쓰레드 자체를 멈추지 않고 내부적으로 따로 정지
    // 즉 쓰레드 내부에서 변수를 공유
    override suspend fun setVote(vote: Vote) {
        try{
            db.collection("votes")
                .document(vote.id)
                .set(vote)
                .await()
            Log.d("FireStore", "투표 성공")

        }
        catch (e: Exception) {
            Log.e("FireStore", "투표 실패 에러 발생")

        }
    }

    override fun observeVoteById(voteId: String): Flow<Vote?> = callbackFlow{
        val listener = db.collection("votes")
            .document(voteId)
            .addSnapshotListener { snapshot, error ->
                if(error!=null){
                    close(error)
                    return@addSnapshotListener
                }

                if(snapshot != null && snapshot.exists()){
                    trySend(snapshot.toObject(Vote::class.java))
                }else
                        trySend(null)
            }

        awaitClose { listener.remove() }
    }
}