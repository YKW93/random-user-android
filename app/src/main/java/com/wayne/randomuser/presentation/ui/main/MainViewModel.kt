package com.wayne.randomuser.presentation.ui.main

import androidx.lifecycle.*
import com.wayne.library.base.BaseViewModel
import com.wayne.randomuser.domain.model.User
import com.wayne.randomuser.domain.usecase.GetUserListUseCase
import com.wayne.randomuser.presentation.mapper.toPresentation
import com.wayne.randomuser.presentation.model.UserPresentation
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(private val getUserListUseCase: GetUserListUseCase) :
    BaseViewModel() {

    private val _isLoading: MutableLiveData<Boolean> = MutableLiveData(false)
    val isLoading: LiveData<Boolean> = _isLoading

    private val userListPageLiveData: MutableLiveData<Int> = MutableLiveData(0)
    val userLiveData: LiveData<List<UserPresentation>> = userListPageLiveData.switchMap {
        liveData {
            emitSource(
                getUserListUseCase(it, 20)
                    .onStart { _isLoading.value = true }
                    .onCompletion { _isLoading.value = false }
                    .map { it.map(User::toPresentation) }
                    .asLiveData()
            )
        }
    }

    fun getUserList(page: Int) {
        userListPageLiveData.value = page
    }
}