package com.example.clazzi

import androidx.compose.material.BottomNavigation
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.padding
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
//import androidx.compose.material.icons.filled.List
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navDeepLink
import com.example.clazzi.repository.FirebaseVoteRepository
import com.example.clazzi.repository.RestApiVoteRepository
import com.example.clazzi.repository.network.ApiClient
import com.example.clazzi.ui.screens.CreateVoteScreen
import com.example.clazzi.ui.screens.VoteListScreen
import com.example.clazzi.ui.screens.VoteScreen
import com.example.clazzi.ui.theme.ClazziTheme
import com.example.clazzi.viewmodel.VoteListViewModel
import com.example.clazzi.ui.screens.AuthScreen
import com.example.clazzi.ui.screens.ChatRoomScreen
import com.example.clazzi.ui.screens.ChatScreen
import com.example.clazzi.ui.screens.MyPageScreen
import com.example.clazzi.viewmodel.VoteListViewModelFactory
import com.example.clazzi.viewmodel.VoteViewModel
import com.example.clazzi.viewmodel.VoteViewModelFactory
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            var name = remember { mutableStateOf("김한수") }
            ClazziTheme {
                val navController = rememberNavController()

                val repo = FirebaseVoteRepository() // 파이어베이스 연동
//                val repo = RestApiVoteRepository(ApiClient.voteApiService) // restapi 연동
                val voteListViewModel: VoteListViewModel = viewModel(
                    factory = VoteListViewModelFactory(repo)
                )
//                val voteListViewModel : VoteListViewModel = viewModel()

                val voteViewModel: VoteViewModel = viewModel(
                    factory = VoteViewModelFactory(repo)
                )

                val isLoggedIn = FirebaseAuth.getInstance().currentUser != null

                // 사용자 등록 (앱 시작 시 닉네임 저장)
                val auth = FirebaseAuth.getInstance()
                LaunchedEffect(auth.currentUser) {
                    auth.currentUser?.let { user ->
                        val nickname = user.uid.take(4)
                        FirebaseFirestore.getInstance().collection("users")
                            .document(user.uid)
                            .set(mapOf("nickname" to nickname))
                    }
                }


                NavHost(
                    navController = navController,
                    startDestination = if (isLoggedIn) "main" else "auth"
                ) {
                    composable("auth") {
                        AuthScreen(
                            navController = navController
                        )
                    }

                    composable("main") {
                        MainScreen(voteListViewModel, navController)
                    }

                    composable(
                        "vote/{voteId}",
                        deepLinks = listOf(
                            navDeepLink { uriPattern = "clazzi://vote/{voteId}" },
                            navDeepLink {
                                uriPattern = "https://clazzi-c27ac.web.app/vote/{voteId}"
                            },
                        )
                    ) { backStackEntry ->
                        val voteId = backStackEntry.arguments?.getString("voteId") ?: "1"
//                        val vote = voteListViewModel.getVoteById(voteId)
                        VoteScreen(
                            voteId = voteId,
                            navController = navController,
                            voteListViewModel = voteListViewModel,
                            voteViewModel = voteViewModel
                        )
                        /*if (vote != null) {
                            VoteScreen(
                                voteId = voteId,
                                navController = navController,
                                voteListViewModel = voteListViewModel
                            )
                        } else {
                            // 에러처리: 특정 ID의 투표가 없을 때의
                            val context = LocalContext.current
                            Toast.makeText(context, "해당 투표가 존재하지 않습니다.", Toast.LENGTH_SHORT).show()
                        }*/
                    }
                    /*composable("createVote") {
                        CreateVoteScreen(
                            onVoteCreate = { vote ->
                                navController.popBackStack() // 뒤로가기
                                voteListViewModel.addVote(vote)
                            }
                        )
                    }*/
                    composable("createVote") {
                        CreateVoteScreen(
                            navController = navController,
                            viewModel = voteListViewModel,
                        )
                    }
                    composable(BottomNavItem.MyPage.route) {
                        MyPageScreen(
                            navController = navController
                        )
                    }
                }
            }
        }
    }
}

sealed class BottomNavItem(val route: String, val icon: ImageVector, val label: String) {
    object VoteList : BottomNavItem("voteList", Icons.AutoMirrored.Filled.List, "투표")
    object Chat : BottomNavItem("chat", Icons.AutoMirrored.Filled.List, "채팅")
    object MyPage : BottomNavItem("myPage", Icons.AutoMirrored.Filled.List, "마이페이지")
}

@Composable
fun MainScreen(
    voteListViewModel: VoteListViewModel,
    parentNavController: NavHostController
) {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(navController)
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "voteList",
            modifier = Modifier
                .padding(innerPadding)
        ) {
            val repo = FirebaseVoteRepository() // 파이어베이스 연동

//            val voteListViewModel : VoteListViewModel = viewModel(
//                factory = VoteListViewModelFactory(repo)
//            )
            composable(BottomNavItem.VoteList.route) {
                VoteListScreen(
                    parentNavController = parentNavController,
                    viewModel = voteListViewModel,
                    onVoteClicked = { voteId ->
                        parentNavController.navigate("vote/$voteId")
                    }
                )
            }
            composable(BottomNavItem.Chat.route) {
                ChatScreen(navController)
            }

            composable("chatRoom/{chatRoomId}/{otherUserId}/{otherNickname}") { backStackEntry ->
                val chatRoomId = backStackEntry.arguments?.getString("chatRoomId") ?: ""
                val otherUserId = backStackEntry.arguments?.getString("otherUserId") ?: ""
                val otherNickname = backStackEntry.arguments?.getString("otherNickname") ?: ""
                ChatRoomScreen(
                    chatRoomId,
                    otherUserId,
                    otherNickname
                )
            }

            composable(BottomNavItem.MyPage.route) {
                MyPageScreen(
                    navController = navController
                )
            }
        }
    }
}

@Composable
fun BottomNavigationBar(navController: NavController) {
    val items = listOf(
        BottomNavItem.VoteList,
        BottomNavItem.Chat,
        BottomNavItem.MyPage,
    )
    BottomNavigation {
        val currentRoute = navController
            .currentBackStackEntryAsState().value?.destination?.route
        items.forEach { item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = item.label) },
                label = { Text(item.label) },
                selected = currentRoute == item.route,
                onClick = {
                    navController.navigate(item.route) {
                        //중복 네비게이션 방지 및 스택 관리
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true

                    }
                }
            )
        }
    }
}