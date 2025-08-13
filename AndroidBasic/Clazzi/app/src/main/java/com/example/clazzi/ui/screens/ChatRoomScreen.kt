package com.example.clazzi.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Card
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.example.clazzi.model.Message
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.launch
import java.text.SimpleDateFormat
import java.util.Date

@Composable
fun ChatRoomScreen(
    chatRoomId: String,
    otherUserId: String,
    otherNickname: String
) {
    val firestore = FirebaseFirestore.getInstance()
    val messages = remember { mutableStateListOf<Message>() }
    val messageText = remember { mutableStateOf("") }
    val auth = FirebaseAuth.getInstance()
    val context = LocalContext.current

    LaunchedEffect(chatRoomId) {
        // 채팅방 문서 생성 또는 확인
        val chatDocRef = firestore.collection("chats").document(chatRoomId)
        chatDocRef.get().addOnSuccessListener { document ->
            if (!document.exists()) {
                // 채팅방이 없으면 문서 생성
                chatDocRef.set(hashMapOf("createdAt" to System.currentTimeMillis()))
                    .addOnSuccessListener {
                        Log.i("ChatRoomScreen", "채팅방 문서 생성 성공 $chatRoomId")
                    }
                    .addOnFailureListener { e ->
                        Log.e("ChatRoomScreen", "채팅방 문서 생성 실패 $chatRoomId", e)
                    }
            }
        }

        // 메시지 실시간 리스너
        chatDocRef.collection("messages")
            .orderBy("timestamp", Query.Direction.DESCENDING)
            .addSnapshotListener { snapshot, e ->
                snapshot?.let {
                    messages.clear()
                    for (doc in it) {
                        messages.add(
                            Message(
                                senderId = doc.getString("senderId") ?: "",
                                content = doc.getString("content") ?: "",
                                timestamp = doc.getLong("timestamp") ?: 0L,
                            )
                        )
                    }
                }
            }
    }

    Column {
        // 채팅방 타이틀
        Text(
            text = "채팅 with $otherNickname",
            modifier = Modifier.padding(bottom = 16.dp),
            style = MaterialTheme.typography.titleLarge
        )
        // 메시지 목록
        LazyColumn(
            modifier = Modifier.weight(1f),
            reverseLayout = true,
        ) {
            items(messages) { message ->
                MessageItem(
                    message = message,
                    isCurrentUser = message.senderId == auth.currentUser?.uid
                )
            }
        }

        // 메시지 입력창
        Row(modifier = Modifier.padding(16.dp)) {
            TextField(
                value = messageText.value,
                onValueChange = { messageText.value = it },
                modifier = Modifier.weight(1f),
                placeholder = { Text("메시지를 입력하세요") }
            )
            Button(
                onClick = {
                    if (messageText.value.isNotBlank()) {
                        val message = Message(
                            senderId = auth.currentUser?.uid ?: "",
                            content = messageText.value,
                            timestamp = System.currentTimeMillis()
                        )
                        firestore.collection("chats")
                            .document(chatRoomId)
                            .collection("messages")
                            .add(message)
                            .addOnSuccessListener {
                                messageText.value = ""
                            }
                            .addOnFailureListener { e ->
                                Log.e("ChatRoomScreen", "메시지 전송 실패", e)
                            }
                    }
                },
            ) {
                Text("전송")
            }
        }
    }
}

@Composable
fun MessageItem(message: Message, isCurrentUser: Boolean) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp),
        horizontalArrangement = if (isCurrentUser) {
            Arrangement.End
        } else {
            Arrangement.Start
        }
    ) {
        Card(
            backgroundColor = if (isCurrentUser) Color(0xFFDCF8C6) else Color.White,
            elevation = 2.dp,
        ) {
            Column(modifier = Modifier.padding(8.dp)) {
                Text(text = message.content)
                Text(
                    text = SimpleDateFormat("HH:mm").format(Date(message.timestamp)),
                    color = Color.Gray
                )
            }
        }
    }
}