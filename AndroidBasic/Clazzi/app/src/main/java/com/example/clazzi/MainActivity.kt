package com.example.clazzi

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clazzi.model.Vote
import com.example.clazzi.model.VoteOption
import com.example.clazzi.ui.screens.CreateVoteScreen
import com.example.clazzi.ui.screens.VoteListScreen
import com.example.clazzi.ui.screens.VoteScreen
import com.example.clazzi.ui.theme.ClazziTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClazziTheme {
                val navController = rememberNavController()
                val voteList = remember {
                    mutableStateListOf(
                        Vote(
                            "1", "오늘 점심 뭐먹을 까요", voteOptions = listOf(
                                VoteOption("1", "삼겹살"),
                                VoteOption("2", "치킨"),
                                VoteOption("3", "피자"),
                            )
                        ), Vote(
                            "2", "오늘 아침 뭐먹을 까요", voteOptions = listOf(
                                VoteOption("1", "달걀"),
                                VoteOption("2", "오유"),
                                VoteOption("3", "맥모닝"),
                            )
                        ), Vote(
                            "3", "오늘 저녁 뭐먹을 까요", voteOptions = listOf(
                                VoteOption("1", "소주"),
                                VoteOption("2", "양주"),
                                VoteOption("3", "맥주"),
                            )
                        )
                    )
                }
                NavHost(
                    navController = navController,
                    startDestination = "voteList"
                ) {
                    composable("voteList") {
                        VoteListScreen(
                            navController = navController,
                            voteList = voteList,
                            onVoteClicked = { voteId ->
                                navController.navigate("vote/$voteId")
                            }
                        )
                    }
                    composable("vote/{voteId}") { backStackEntry ->
                        val voteId = backStackEntry.arguments?.getString("voteId") ?: "1"
                        VoteScreen(
                            vote = voteList.first {
                                it.id == voteId
                            },
                            navController = navController
                        )
//                        VoteScreen(vote = voteList.find { it.id == voteId })
                    }
                    composable("createVote") {
                        CreateVoteScreen(
                            onVoteCreate = { vote ->
                                navController.popBackStack() // 뒤로가기
                                voteList.add(vote)
                            }
                        )
                    }
                }
            }
        }
    }
}

