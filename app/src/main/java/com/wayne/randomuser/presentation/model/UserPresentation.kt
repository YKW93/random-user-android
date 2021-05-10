package com.wayne.randomuser.presentation.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class UserPresentation(
    val cell: String,
    val email: String,
    val gender: String,
    val name: String,
    val pictureUrl: String
) : Parcelable