package com.wayne.randomuser.presentation.ui.details

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.wayne.library.base.BaseViewModel
import com.wayne.library.utils.BackDirections
import com.wayne.randomuser.presentation.model.UserPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UserDetailsViewModel @Inject constructor() : BaseViewModel() {

    private val _userPresentation = MutableLiveData<UserPresentation>()
    val userPresentation = _userPresentation

    init {
        viewModelScope.launch {
            navArgs<UserDetailsFragmentArgs>().collect {
                _userPresentation.value = it.user
            }
        }
    }

    fun goToBack() {
        navDirections.value = BackDirections()
    }
}