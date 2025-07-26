package com.wj.a7navigation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.wj.a7navigation.ui.theme._7NavigationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            _7NavigationTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()

                    NavHost(
                        navController = navController,
                        startDestination = "first",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("first") {
                            FirstScreen(navController = navController)
                        }
                        composable("second") {
                            SecondScreen()
                        }
                        composable("third/{value}") { backStackEntry ->
                            ThirdScreen(
                                value = backStackEntry.arguments?.getString("value")?:"",
                                navController = navController
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun FirstScreen(
    navController: NavHostController
) {
    var (text, setText) = remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("첫 번째 화면")
        Button(onClick = { navController.navigate("second") }) {
            Text("두 번째 화면으로 이동")
        }
        Spacer(modifier = Modifier.height(16.dp))
        TextField(
            value = text,
            onValueChange = setText,
        )
        Button(onClick = { navController.navigate("third/$text") }) {
            Text("세 번째 화면으로 이동")
        }
    }
}

@Composable
fun SecondScreen() {
    Text("두 번째 화면")
}

@Composable
fun ThirdScreen(
    value: String,
    navController: NavHostController
) {
    Column (
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ){
        Text("세 번째 화면")
        Text("받아 온 텍스트: $value")
        Button(onClick = {navController.navigateUp()}) {
            Text("뒤로 가기")
        }
    }
}