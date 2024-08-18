// UserListScreen.kt
package com.example.myapp.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.myapp.data.User
import com.example.myapp.viewmodel.UserViewModel

@Composable
fun UserListScreen(viewModel: UserViewModel = viewModel()) {
    val users by viewModel.users.collectAsState(initial = emptyList())

    Column(modifier = Modifier.padding(16.dp)) {
        Text("User List", style = MaterialTheme.typography.titleLarge)

        Spacer(modifier = Modifier.height(16.dp))

        if (users.isEmpty()) {
            Text("No users found.")
        } else {
            users.forEach { user ->
                UserItem(user)
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}

@Composable
fun UserItem(user: User) {
    Card(modifier = Modifier.fillMaxWidth().padding(8.dp)) {
        Column(modifier = Modifier.padding(16.dp)) {
            Text(text = "Name: ${user.name}")
            Text(text = "Age: ${user.age}")
            Text(text = "DOB: ${user.dob}")
            Text(text = "Address: ${user.address}")
        }
    }
}
