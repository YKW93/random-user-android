package com.wayne.randomuser.domain.usecase

import com.wayne.randomuser.domain.model.User
import com.wayne.randomuser.domain.repository.UserRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import javax.inject.Inject


class GetUserListUseCase @Inject constructor(private val userRepository: UserRepository) {
    suspend operator fun invoke(page: Int, results: Int): Flow<List<User>> {
        return userRepository.getUsers(page, results)
    }
}