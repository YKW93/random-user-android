package com.wayne.randomuser.data.remote.source

import com.wayne.randomuser.data.remote.api.ApiService
import com.wayne.randomuser.data.remote.model.UserResponse
import javax.inject.Inject


class UserRemoteDataSource @Inject constructor(private val apiService: ApiService) {
    suspend fun getUsers(page: Int, results: Int): UserResponse {
        return apiService.getUser(page, results)
    }
}