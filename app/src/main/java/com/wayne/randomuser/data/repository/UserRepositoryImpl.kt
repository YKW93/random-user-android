package com.wayne.randomuser.data.repository

import com.wayne.randomuser.data.remote.mapper.toDomain
import com.wayne.randomuser.data.remote.model.UserResponse
import com.wayne.randomuser.data.remote.source.UserRemoteDataSource
import com.wayne.randomuser.domain.model.User
import com.wayne.randomuser.domain.repository.UserRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject


class UserRepositoryImpl @Inject constructor(private val userRemoteDataSource: UserRemoteDataSource) :
    UserRepository {

    override fun getUsers(page: Int, results: Int): Flow<List<User>> = flow {
        emit(
            userRemoteDataSource.getUsers(page, results).results
                .map(UserResponse.Result::toDomain)
        )
    }.flowOn(Dispatchers.IO)
}