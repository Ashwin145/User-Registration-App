package com.example.myapp.data

import kotlinx.coroutines.flow.Flow

class UserRepository(private val userDao: UserDao) {

    fun getAllUsers(): Flow<List<User>> {
        return userDao.getAllUsers()
    }

    suspend fun insert(user: User) {
        userDao.insert(user)
    }
}
