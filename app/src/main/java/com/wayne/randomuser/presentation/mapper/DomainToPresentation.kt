package com.wayne.randomuser.presentation.mapper

import com.wayne.randomuser.domain.model.User
import com.wayne.randomuser.presentation.model.UserPresentation

fun User.toPresentation(): UserPresentation {
    return UserPresentation(cell, email, gender, name, pictureUrl)
}