package com.example.myapp.ui

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.testTag
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.myapp.data.User
import com.example.myapp.viewmodel.UserViewModel
import java.util.Calendar

@Composable
fun UserInputScreen(navController: NavHostController, viewModel: UserViewModel = viewModel()) {
    val context = LocalContext.current

    // State variables
    var name by remember { mutableStateOf("") }
    var age by remember { mutableStateOf("") }
    var dob by remember { mutableStateOf("") }
    var address by remember { mutableStateOf("") }

    // Calendar-related variables
    val calendar = Calendar.getInstance()
    val year = calendar.get(Calendar.YEAR)
    val month = calendar.get(Calendar.MONTH)
    val day = calendar.get(Calendar.DAY_OF_MONTH)

    // DatePickerDialog to pick a date
    val datePickerDialog = DatePickerDialog(
        context,
        { _, selectedYear, selectedMonth, selectedDay ->
            dob = "$selectedDay/${selectedMonth + 1}/$selectedYear"
        },
        year,
        month,
        day
    )

    // Enhanced Background Gradient
    val gradientBackground = Brush.verticalGradient(
        colors = listOf(Color(0xFFFC466B), Color(0xFF3F5EFB)) // Pink to Blue gradient
    )

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(gradientBackground)
            .padding(16.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(10.dp, RoundedCornerShape(24.dp))
                .background(
                    brush = Brush.linearGradient(
                        colors = listOf(Color.White, Color(0xFFF0F4F8))
                    ),
                    shape = RoundedCornerShape(24.dp)
                )
                .padding(24.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "User Registration",
                fontSize = 28.sp,
                fontWeight = FontWeight.Bold,
                color = Color(0xFF3F5EFB), // Blue shade for the title
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .testTag("TitleText") // Tag for testing
            )

            TextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Name") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .shadow(5.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .testTag("NameInput") // Tag for testing
            )

            TextField(
                value = age,
                onValueChange = { age = it },
                label = { Text("Age") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .shadow(5.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .testTag("AgeInput") // Tag for testing
            )

            // Date of Birth with DatePicker
            TextField(
                value = dob,
                onValueChange = { dob = it },
                label = { Text("Date of Birth") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .clickable { datePickerDialog.show() }
                    .shadow(5.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .testTag("DateOfBirthInput"), // Tag for testing
                enabled = false // Disable manual input to enforce date selection from the picker
            )

            TextField(
                value = address,
                onValueChange = { address = it },
                label = { Text("Address") },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 8.dp)
                    .shadow(5.dp, RoundedCornerShape(12.dp))
                    .background(Color.White, RoundedCornerShape(12.dp))
                    .testTag("AddressInput") // Tag for testing
            )

            Spacer(modifier = Modifier.height(24.dp))

            Button(
                onClick = {
                    if (name.isNotEmpty() && age.isNotEmpty() && dob.isNotEmpty() && address.isNotEmpty()) {
                        viewModel.addUser(User(name = name, age = age.toInt(), dob = dob, address = address))
                        Toast.makeText(context, "User added successfully", Toast.LENGTH_SHORT).show()
                        navController.navigate("user_list") // Navigate to UserListScreen after adding user
                    } else {
                        Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
                    }
                },
                shape = CircleShape,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Color(0xFFFC466B) // Vibrant pink color
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 32.dp)
                    .shadow(8.dp, CircleShape)
                    .height(56.dp)
                    .testTag("SubmitButton") // Tag for testing
            ) {
                Text(
                    text = "Submit",
                    color = Color.White,
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
    }
}

@Preview
@Composable
fun UserInputScreenPreview() {
    UserInputScreen(navController = rememberNavController())
}