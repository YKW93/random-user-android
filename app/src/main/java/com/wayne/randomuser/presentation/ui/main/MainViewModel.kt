package com.wayne.randomuser.presentation.ui.main

import com.wayne.library.base.BaseViewModel
import com.wayne.randomuser.domain.usecase.GetUserListUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getUserListUseCase: GetUserListUseCase) :
    BaseViewModel() {

}