package com.wayne.randomuser.data.remote.mapper

import com.wayne.randomuser.data.remote.model.UserResponse
import com.wayne.randomuser.domain.model.User

fun UserResponse.Result.toDomain(): User {
    return User(
        cell = cell,
        email = email,
        gender = gender,
        name = name.last + name.first,
        pictureUrl = picture.large
    )
}