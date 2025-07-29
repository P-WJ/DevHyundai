package com.wj.calculator

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import com.wj.calculator.ui.theme.CalculatorTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            val viewModel: CalculatorViewModel = viewModel()
            val buttons = listOf(
                "7", "8", "9", "/",
                "4", "5", "6", "*",
                "1", "2", "3", "-",
                "C", "0", "=", "+",
            )
            CalculatorTheme {
                Scaffold { innerPadding ->
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(innerPadding)
                            .padding(16.dp),
                    ) {
                        // 상단 영역
                        Box(
                            modifier = Modifier
                                .weight(1f)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Text(viewModel.input.value)
                        }
                        // 하단 영역

                        LazyVerticalGrid(
                            columns = GridCells.Fixed(4),
                            horizontalArrangement = Arrangement.spacedBy(16.dp), // 가로 간격
                            verticalArrangement = Arrangement.spacedBy(16.dp),  // 세로 간격
                        ) {
                            items(buttons) { label ->
                                Button(
                                    onClick = { viewModel.onButtonClick(label) },
                                    shape = RoundedCornerShape(8.dp),
                                    modifier = Modifier.height(48.dp)
                                ) {
                                    Text(text = label)
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}

class CalculatorViewModel : ViewModel() {
    private val _display = mutableStateOf("")
    val input: State<String> = _display

    private var inputA = ""
    private var inputB = ""
    private var operator = ""
    private var isOperator = false

    fun onButtonClick(label: String) {
        when (label) {
            "C" -> {
                inputA = ""
                inputB = ""
                operator = ""
                isOperator = false
                _display.value = ""
            }

            "=" -> _display.value = onEqualClick(operator, inputA, inputB)
            "+", "-", "*", "/" -> {
                isOperator = true
                operator = label
                _display.value = inputA + operator
            }

            else -> {
                if (!isOperator) {
                    inputA += label
                    _display.value = inputA
                } else {
                    inputB += label
                    _display.value = inputA + operator + inputB
                }
            }
        }
    }
}

fun onEqualClick(operator: String, inputA: String, inputB: String): String {
    val result = when (operator) {
        "+" -> inputA.toDouble() + inputB.toDouble()
        "-" -> inputA.toDouble() - inputB.toDouble()
        "*" -> inputA.toDouble() * inputB.toDouble()
        "/" -> inputA.toDouble() / inputB.toDouble()
        else -> inputB.toDouble()
    }
    return result.toString()
}