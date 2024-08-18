package com.example.myapp.ui

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.myapp.ui.theme.MyAppTheme
import com.example.myapp.ui.theme.UserListScreen
import com.example.myapp.viewmodel.UserViewModel

@Composable
fun MyAppNavGraph(
    navController: NavHostController = rememberNavController(),
    viewModel: UserViewModel = viewModel()
) {
    NavHost(navController = navController, startDestination = "user_input") {
        composable("user_input") {
            UserInputScreen(navController, viewModel)
        }
        composable("user_list") {
            UserListScreen(viewModel)
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Preview(showBackground = true)
@Composable
fun MyAppNavGraphPreview() {
    MyAppTheme {
        Surface(color = MaterialTheme.colorScheme.background) {
            MyAppNavGraph()
        }
    }
}
