package com.example.voterestapiandroid

import android.net.Uri
import android.os.Bundle
import android.view.View
import androidx.activity.ComponentActivity
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.result.contract.ActivityResultContract
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import coil.compose.rememberAsyncImagePainter
import com.example.voterestapiandroid.ui.theme.VoteRestApiAndroidTheme
import java.io.File
import java.io.FileOutputStream

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            VoteRestApiAndroidTheme {
                MainView()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    VoteRestApiAndroidTheme {
        MainView()
    }
}

@Composable
fun MainView(){
    val navController = rememberNavController();
    val viewModel: VoteViewModel = viewModel()

    Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "voteList",
            modifier = Modifier
                .padding(innerPadding)
                .padding(16.dp)
        ){
            composable("voteList"){
                VoteListView(
                    viewModel = viewModel,
                    onVoteClick = { voteId ->
                        navController.navigate("vote/$voteId")
                    },
                    onVoteCreate = {
                        navController.navigate("createVote")
                    }
                )
            }

            composable("createVote") {
                CreateVoteView(viewModel) {
                    navController.navigateUp()
                }
            }

            composable("vote/{voteId}"){ backStackEntry ->
                val voteId = backStackEntry.arguments?.getString("voteId")?.toIntOrNull()
                if(voteId != null){
                    VoteView(viewModel = viewModel, voteId = voteId)
                }else{
                    navController.navigateUp()
                }
            }
        }

    }
}

@Composable
fun VoteListView(
    viewModel: VoteViewModel,
    onVoteClick: (Int) -> Unit,
    onVoteCreate: () -> Unit
) {
    LaunchedEffect(Unit) {
        viewModel.fetchVotes()
    }

    val votes = viewModel.votes

    LazyColumn(
    ) {
        items(votes) { vote ->
            Text(vote.title,
                modifier = Modifier
                    .clickable { onVoteClick(vote.id!!)})
        }
        item {
            Button(onClick = onVoteCreate) {
                Text("Create Vote")
            }
        }
    }
}

@Composable
fun VoteView(
    viewModel: VoteViewModel,
    voteId: Int){
    LaunchedEffect(voteId) {
        viewModel.fetchVoteById(voteId)
    }

    val vote = viewModel.vote

    if (vote != null) {
        Column{
            Text(vote.title)
            Text(vote.description)
        }
    } else {
        Text("투표 정보를 찾을 수 없습니다.")
    }
}

@Composable
fun CreateVoteView(
    viewModel: VoteViewModel,
    onNavigateBack: () -> Unit

) {
    val context = LocalContext.current

    var title by remember { mutableStateOf("") }
    var description by remember { mutableStateOf("") }
    var imageUri by remember { mutableStateOf<Uri?>(null) }
    var imageFile by remember { mutableStateOf<File?>(null) }

    val launcher = rememberLauncherForActivityResult(
        ActivityResultContracts.GetContent()
    ) { uri: Uri? ->
        uri?.let {
            imageUri = it
            // URI를 파일로 변환
            val inputStream = context.contentResolver.openInputStream(uri)
            val file = File(context.cacheDir, "image_${System.currentTimeMillis()}.jpg")
            inputStream?.use { input ->
                FileOutputStream(file).use { output ->
                    input.copyTo(output)
                }
            }
            imageFile = file
        }
    }

    Column {
        OutlinedTextField(
            value = title,
            onValueChange = { title = it },
            label = { Text("Title") },
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = description,
            onValueChange = { description = it },
            label = { Text("Description") },
            modifier = Modifier.fillMaxWidth()
        )

        Button(
            onClick = {
                launcher.launch("image/*")
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("앨범 사진 선택")
        }

        imageUri?.let {
            Image(
                painter = rememberAsyncImagePainter(it),
                contentDescription = null,
                modifier = Modifier
                    .size(200.dp)
                    .padding(8.dp)
            )
        }

        Button(
            onClick = {
//                viewModel.createVote(title, description)
                viewModel.createVote(title, description, imageFile)
                onNavigateBack()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Create")
        }
    }
}
