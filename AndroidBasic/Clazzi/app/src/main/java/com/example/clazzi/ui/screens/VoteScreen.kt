package com.example.clazzi.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Check
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import coil.compose.rememberAsyncImagePainter
import com.example.clazzi.util.formatDate
import com.example.clazzi.viewmodel.VoteListViewModel
import com.example.clazzi.viewmodel.VoteViewModel
import com.google.firebase.auth.FirebaseAuth
import kotlinx.coroutines.launch
import java.util.Date
import kotlin.math.log

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun VoteScreen(voteId: String, navController: NavController, voteViewModel: VoteViewModel ,voteListViewModel: VoteListViewModel) {
//    val voteViewModel: VoteViewModel = viewModel()

    // 초기 데이터 로드
    LaunchedEffect(voteId) {
        voteViewModel.loadVote(voteId)
    }

    // vote 스테이트
    val vote = voteViewModel.vote.collectAsState().value

    val user = FirebaseAuth.getInstance().currentUser
    val currentUserId = user?.uid ?: "0"
    var hasVoted by remember { mutableStateOf(false) }
    LaunchedEffect(vote) {
        if (vote != null) {
            hasVoted = vote.voteOptions.any { option ->
                option.voters.contains(currentUserId)
            }
        }
    }

    // 전체 투표수
    val totalVotes = vote?.voteOptions?.sumOf { it.voters.size } ?: 1

    var selectionOption by remember { mutableStateOf(0) }

    var coroutineScope = rememberCoroutineScope()

    // 투표 마감
    var isBeforeDeadline by remember { mutableStateOf(false) }
    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(text = "투표") },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(
                            Icons.AutoMirrored.Filled.ArrowBack,
                            contentDescription = "뒤로가기"
                        )
                    }
                },
                actions = {
                    IconButton(
                        onClick = {
                            if (vote != null) {

                                val voteUrl = "https://clazzi-54344.web.app/vote/${vote.id}"
                                val sendIntent = Intent().apply {
                                    action = Intent.ACTION_SEND
                                    putExtra(Intent.EXTRA_TEXT, voteUrl)
                                    type = "text/plain"
                                }
                                navController.context.startActivity(
                                    Intent.createChooser(
                                        sendIntent,
                                        "투표공유"
                                    )
                                )
                            }

                        }
                    ) { Icon(Icons.Default.Share, contentDescription = "투표공유") }
                })
        },
    ) { innerPadding ->
        if (vote == null) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(innerPadding),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator()
            }
        } else {
            LaunchedEffect(vote.deadline) {
                isBeforeDeadline = vote.deadline?.let {
                    Date().before(it)
                } ?: false

            }
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .fillMaxSize()
                    .verticalScroll(
                        rememberScrollState()
                    ),
                horizontalAlignment = Alignment.CenterHorizontally,


                ) {
                Text(
                    text = buildAnnotatedString {
                        append("친구들과 ")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("서로 투표")
                        }
                        append("하며\n")
                        withStyle(style = SpanStyle(fontWeight = FontWeight.Bold)) {
                            append("익명")
                        }
                        append("으로 마음을 전해요")
                    }, fontSize = 18.sp
                )
                Spacer(modifier = Modifier.height(40.dp))
                Text(
                    text = vote.title, style = TextStyle(
                        fontSize = 20.sp, fontWeight = FontWeight.Bold
                    )
                )

                Spacer(modifier = Modifier.height(20.dp))

                Image(
                    painter = if (vote.imageUrl != null) rememberAsyncImagePainter(vote.imageUrl) else
                        painterResource(id = android.R.drawable.ic_menu_gallery),
                    contentDescription = "투표 사진",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .size(120.dp)
                        .clip(CircleShape)
                        .background(Color.LightGray)
                )
                Spacer(Modifier.height(20.dp))
                Text(
                    text = if (isBeforeDeadline) {
                        "투표 마감: ${formatDate(vote.deadline)}"
                    } else {
                        "투표 마감"
                    }
                )
                Spacer(Modifier.height(20.dp))



                if (!hasVoted) { //투표하지 않았을 때
                    vote.voteOptions.forEachIndexed { index, voteOption ->
                        Button(
                            onClick = {
                                selectionOption = index
                            },
                            colors = ButtonDefaults.buttonColors(
                                if (selectionOption == index) Color(0xFF13F8A5) else Color.LightGray.copy(
                                    alpha = 0.5f
                                )
                            ),
                            modifier = Modifier.width(200.dp)
                        ) {
                            Text(voteOption.optionText)
                        }

                        Spacer(Modifier.height(20.dp))
                    }
                } else { // 투표했을 때
                    vote.voteOptions.sortedByDescending { it.voters.size }.forEach { option ->
                        val isMyVote = option.voters.contains(currentUserId)
                        val percentage = option.voters.size.toFloat() / totalVotes

                        Column(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp)
                                .background(
                                    if (isMyVote) Color(0xFF13F8A5).copy(0.4f)
                                    else Color.LightGray.copy(0.3f),
                                    shape = RoundedCornerShape(12.dp)
                                )
                                .padding(12.dp)

                        ) {
                            Row(
                                verticalAlignment = Alignment.CenterVertically,
                                modifier = Modifier.fillMaxWidth()
                            ) {
                                Text(
                                    text = option.optionText,
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    modifier = Modifier.weight(1f)
                                )

                                Text(
                                    text = "${(percentage * 100).toInt()}%",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold
                                )
                                if (hasVoted) {
                                    Icon(
                                        imageVector = Icons.Default.Check,
                                        contentDescription = "내가 투표한 항목",
                                        tint = Color(0xFF13F8A5),
                                        modifier = Modifier.padding(8.dp)
                                    )
                                }

                            }

                            Spacer(modifier = Modifier.height(4.dp))
                            LinearProgressIndicator(
                                progress = { percentage },
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .height(8.dp)
                                    .clip(RoundedCornerShape(4.dp)),
                                color = Color(0xFF13F8A5),
                                trackColor = Color.White.copy(alpha = 0.4f),
//                                strokeCap = ProgressIndicatorDefaults.LinearStrokeCap,
                            )
                        }
                    }
                }





                Button(
                    onClick = {
                        if (!hasVoted) {
                            coroutineScope.launch {

                                val selectedOption = vote.voteOptions[selectionOption]

                                val updatedOption = selectedOption.copy(
                                    voters = selectedOption.voters + currentUserId
                                )

                                val updatedOptions = vote.voteOptions.mapIndexed { index, option ->
                                    if (index == selectionOption) updatedOption else option
                                }
                                val updatedVote = vote.copy(
                                    voteOptions = updatedOptions,
                                )

                                voteListViewModel.setVote(updatedVote)
                            }
                        }
                    },
                    enabled = !hasVoted && isBeforeDeadline,
                    modifier = Modifier.width(200.dp)
                ) {
                    Text(
                        if (!isBeforeDeadline) {
                            "투표마감"
                        } else if (hasVoted) {
                            "투표함"
                        } else "투표하기"
                    )
                }

            }
        }

    }
}


//@Preview(showBackground = true)
//@Composable
//fun VoteScreenPreview() {
//    ClazziTheme {
//        VoteScreen(
//            Vote(
//                "1", "오늘 점심 뭐먹을 까요", listOf(
//                    VoteOption("1", "삼겹살"),
//                    VoteOption("2", "치킨"),
//                    VoteOption("3", "피자"),
//                )
//            ),
//            navController = Any(
//        )
//    }
//}