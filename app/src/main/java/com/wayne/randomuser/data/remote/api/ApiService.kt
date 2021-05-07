package com.wayne.randomuser.data.remote.api

import com.wayne.randomuser.data.remote.model.UserResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/")
    suspend fun getUser(
        @Query("page") page: Int,
        @Query("results") results: Int
    ): UserResponse
}