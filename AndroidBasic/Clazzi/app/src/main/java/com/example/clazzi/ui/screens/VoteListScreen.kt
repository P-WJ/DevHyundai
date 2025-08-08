package com.example.clazzi.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import com.example.clazzi.model.Vote
import com.example.clazzi.model.VoteOption
import com.example.clazzi.ui.theme.ClazziTheme
import com.example.clazzi.util.formatDate
import com.example.clazzi.viewmodel.VoteListViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteListScreen(
    navController: NavHostController,
    viewModel: VoteListViewModel,
    onVoteClicked: (String) -> Unit
) {
    val voteList by viewModel.voteList.collectAsState()
    Scaffold(topBar = {
        TopAppBar(
            title = { Text(text = "투표 목록") })
    }, floatingActionButton = {
        FloatingActionButton(
            onClick = {
                navController.navigate("createVote")
            }
        ) {
            Icon(Icons.Default.Add, contentDescription = "투표 만들기")
        }
    }) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding),

            contentPadding = PaddingValues(16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(voteList) { vote ->
                VoteItem(vote) {
                    onVoteClicked(it)
                }

            }
        }
    }
}

@Composable
fun VoteItem(
    vote: Vote,
    onVoteClicked: (String) -> Unit
) {
    Card {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .clickable{
                    onVoteClicked(vote.id)
                }
        ) {
            Column (
                modifier = Modifier.padding(16.dp)
            ) { Text(vote.title, style = MaterialTheme.typography.titleMedium)
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = "생성일: ${formatDate(vote.createAt)}",
                    style = MaterialTheme.typography.bodySmall

                )
                Text(
                    text = "항목 개수: ${vote.optionCount}",
                    style = MaterialTheme.typography.bodySmall
                )
            }

        }
    }
}

@Preview(showBackground = true)
@Composable
fun VoteListScreenPreview() {
    ClazziTheme {
        VoteListScreen(
            navController = NavHostController(LocalContext.current),
            viewModel = viewModel(),
            onVoteClicked = {}
        )
    }
}