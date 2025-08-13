package com.example.clazzi.ui.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.clazzi.R
import com.example.clazzi.model.Vote
import com.example.clazzi.model.VoteOption
import com.example.clazzi.ui.theme.ClazziTheme
import com.example.clazzi.util.formatDate
import com.example.clazzi.viewmodel.VoteListViewModel
import com.google.firebase.auth.FirebaseAuth
import java.nio.file.WatchEvent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteListScreen(
    parentNavController: NavHostController,
    viewModel: VoteListViewModel,
    onVoteClicked: (String) -> Unit
) {
    val voteList by viewModel.voteList.collectAsState()
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(stringResource(id= R.string.vote_list_title)) },
                actions = {
                    IconButton(onClick = {
                        parentNavController.navigate("mypage")
                    }){
                        Icon(imageVector = Icons.Default.Person,
                            contentDescription = "유저")
                    }
                }
            )

        },
        floatingActionButton = {
            FloatingActionButton(onClick = { parentNavController.navigate("createVote") }) {
                Icon(Icons.Default.Add, contentDescription = "생성하기")
            }
        }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),
            contentPadding = PaddingValues(16.dp)
//                .padding(16.dp)
            ,
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(voteList) { vote ->
                VoteItem(vote,onVoteClicked)
            }
        }
    }
}

@Composable
fun VoteItem(
    vote: Vote,
    onVoteClicked: (String) -> Unit
) {
    val user = FirebaseAuth.getInstance().currentUser
    val currentUserId = user?.uid ?: "0"

    // hasVoted 상태 : 사용자가 투표햇는지 판다
    var hasVoted by remember { mutableStateOf(false) }
    LaunchedEffect(vote) {
        hasVoted = vote.voteOptions.any {
                option -> option.voters.contains(currentUserId)
        }
    }
    Card (modifier = Modifier.fillMaxWidth().clickable { onVoteClicked(vote.id) }){
        Row (modifier = Modifier.padding(16.dp)){
            Column(
                modifier = Modifier
                    .weight(1f)
                //                            .clickable { navController.navigate("vote") }
            )
            {
                Text(
                    vote.title,
                    style = MaterialTheme.typography.titleMedium
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "생성일 : ${formatDate(vote.createAt)}",
                    style = MaterialTheme.typography.bodySmall
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "항목 개수 : ${vote.optionCount}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

            // 투표 여부
            Text(if(hasVoted) "투표함" else "투표하기")
        }
    }

}


