package com.wayne.randomuser.domain.di

import com.wayne.randomuser.domain.repository.UserRepository
import com.wayne.randomuser.domain.usecase.GetUserListUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityRetainedComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped

@Module
@InstallIn(ActivityRetainedComponent::class)
object UseCaseModule {
    @Provides
    @ActivityRetainedScoped
    fun provideUserListUseCase(userRepository: UserRepository): GetUserListUseCase {
        return GetUserListUseCase(userRepository)
    }
}