package com.wayne.randomuser.domain.repository

import com.wayne.randomuser.domain.model.User
import kotlinx.coroutines.flow.Flow

interface UserRepository {
    suspend fun getUsers(page: Int, results: Int): Flow<List<User>>
}