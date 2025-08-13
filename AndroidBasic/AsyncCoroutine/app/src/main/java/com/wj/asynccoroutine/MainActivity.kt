package com.wj.asynccoroutine

import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import com.wj.asynccoroutine.ui.theme.AsyncCoroutineTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MainScreen()
        }
    }
}

@Composable
fun MainScreen() {
    var data by remember { mutableStateOf("데이터를 로드 하세요") }
    Column(
        modifier = Modifier
            .fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(data)

        val coroutineScope = rememberCoroutineScope()
        Button(

            // ANR : Application Not Responding
            // 5초 이상 아무 응답이 없으면 나는 에러(앱이 멈추고 종료된다)
            onClick = {
//                Thread.sleep(5000)
//                data = fetchSyncData()
                coroutineScope.launch {
                    val result = fetchAsyncData()
                    withContext(Dispatchers.Main) {
                        data = result
                    }
                }
            }
        ) {
            Text("데이터 로드")
        }
        val context = LocalContext.current
        Button(
            onClick = {
                Toast.makeText(context,"두번째 버튼 클릭", Toast.LENGTH_SHORT).show()
            }
        ) {
            Text("두번째 버튼")
        }

    }
}

fun fetchSyncData(): String {
    return "동기적으로 가져온 데이터"
}

suspend fun fetchAsyncData(): String {
//    Thread.sleep(5000)
//    delay(5000)
    fetchDetailDataFromNetwork()
    return "코루틴으로 가져온 데이터"
}

suspend fun fetchDetailDataFromNetwork(): String {
    println("작업 스레드: ${Thread.currentThread().name}")
    delay(2000)
    return "코루틴으로 가져온 데이터!!"
}