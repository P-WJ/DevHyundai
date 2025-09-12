package com.example.androidcomposetdd.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.unit.dp
import androidx.hilt.lifecycle.viewmodel.compose.hiltViewModel
import com.example.androidcomposetdd.viewmodel.TextViewModel

@Composable
fun TextScreen(viewModel: TextViewModel = hiltViewModel()) {
    Column(modifier = Modifier.padding(16.dp)) {
        TextField(
            value = viewModel.displayText,
            onValueChange = { viewModel.updateText(it) },
            modifier = Modifier.testTag("textInput"),
            label = { Text("Enter text") }
        )
        Text(
            text = viewModel.displayText,
            modifier = Modifier.testTag("displayText")
        )
    }
}