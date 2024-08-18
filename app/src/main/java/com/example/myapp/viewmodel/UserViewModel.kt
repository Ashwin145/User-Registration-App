package com.example.myapp.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.myapp.data.User
import com.example.myapp.data.UserDatabase
import com.example.myapp.data.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class UserViewModel(application: Application) : AndroidViewModel(application) {

    private val repository: UserRepository

    // Expose user list as StateFlow
    private val _users = MutableStateFlow<List<User>>(emptyList())
    val users: StateFlow<List<User>> get() = _users

    init {
        val userDao = UserDatabase.getDatabase(application).userDao()
        repository = UserRepository(userDao)
        // Fetch users from the repository and update the StateFlow
        viewModelScope.launch {
            repository.getAllUsers().collect { userList ->
                _users.value = userList
            }
        }
    }

    fun addUser(user: User) {
        viewModelScope.launch {
            repository.insert(user)
            // Refresh the user list after adding a user
            repository.getAllUsers().collect { userList ->
                _users.value = userList
            }
        }
    }
}
