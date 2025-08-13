package com.example.clazzi.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import com.google.firebase.auth.FirebaseAuth


@Composable
fun MyPageScreen(navController : NavController) {
    val auth = FirebaseAuth.getInstance()
    Scaffold (
        modifier = Modifier
            .fillMaxSize(),
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        )
        {
            val uid = FirebaseAuth.getInstance().currentUser?.uid ?: "닉네임 없음"
            Text(uid.take(4))
            Button(
                onClick = {
                    auth.signOut()
                    navController.navigate("auth") {
                        popUpTo(0) {inclusive = true} // 전체 스택 제거
                        launchSingleTop = true // 중복 방지
                    }
                }
            )
            {
                Text("로그아웃")
            }
        }
    }
}