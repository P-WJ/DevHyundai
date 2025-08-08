package com.example.clazzi

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.clazzi.model.Vote
import com.example.clazzi.model.VoteOption
import com.example.clazzi.ui.screens.CreateVoteScreen
import com.example.clazzi.ui.screens.VoteListScreen
import com.example.clazzi.ui.screens.VoteScreen
import com.example.clazzi.ui.theme.ClazziTheme
import com.example.clazzi.viewmodel.VoteListViewModel

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ClazziTheme {
                val navController = rememberNavController()
                val voteListViewModel = viewModel<VoteListViewModel>()
                NavHost(
                    navController = navController,
                    startDestination = "voteList"
                ) {
                    composable("voteList") {
                        VoteListScreen(
                            navController = navController,
                            viewModel = voteListViewModel,
                            onVoteClicked = { voteId ->
                                navController.navigate("vote/$voteId")
                            }
                        )
                    }
                    composable("vote/{voteId}") { backStackEntry ->
                        val voteId = backStackEntry.arguments?.getString("voteId") ?: "1"
                        val vote = voteListViewModel.getVoteById(voteId)
                        if (vote != null) {
                            VoteScreen(
                                vote = vote,
                                navController = navController,
                                viewModel = voteListViewModel
                            )
                        } else {

                            // 특정 ID의 투표가 없을 때의 에러처리
                            val context = LocalContext.current
                            Toast.makeText(context,"해당 투표가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
                        }
                    }
/*                    composable("createVote") {
                        CreateVoteScreen(
                            onVoteCreate = { vote ->
                                navController.popBackStack() // 뒤로가기
                                voteListViewModel.addVote(vote)
                            }
                        )*/


                        composable("createVote") {
                            CreateVoteScreen(
                                navController = navController,
                                viewModel = voteListViewModel
                            )
                        }
                }
            }
        }
    }
}

