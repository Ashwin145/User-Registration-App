package com.example.myapp.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface UserDao {
    @Insert
    suspend fun insert(user: User)

    @Query("SELECT * FROM user_table") // Changed to match the table name in User entity
    fun getAllUsers(): Flow<List<User>>
}
