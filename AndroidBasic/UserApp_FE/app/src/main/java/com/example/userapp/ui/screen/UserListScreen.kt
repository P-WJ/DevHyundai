package com.example.userapp.ui.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.userapp.viewmodel.UserViewModel

@Composable
fun UserListScreen(viewModel: UserViewModel, navController: NavController) {
    val users by viewModel.users.collectAsState()
    var name by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }

    LaunchedEffect(viewModel) {
        viewModel.loadUsers()
    }

    Column(modifier = Modifier.padding(16.dp)) {
        OutlinedTextField(
            value = name,
            onValueChange = {name = it},
            label = { Text("Name") },
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = { Text("Email") },
        )
        Spacer(Modifier.height(8.dp))
        Button(onClick = {
            if (name.isNotBlank() && email.isNotBlank()) {
                viewModel.addUser(name, email)
                name = ""
                email = ""
            }
        }
        ) {
            Text("Add User")
        }

        Spacer(Modifier.height(16.dp))

        LazyColumn {
            items(users) { user ->
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 4.dp)
                        .clickable { navController.navigate("userDetail/${user.id}") }
                ) {
                    Column(modifier = Modifier.padding(16.dp)) {
                        Text(user.name)
                        Text(user.email)
                    }
                }
            }
        }
    }
}