package com.wayne.randomuser.data.remote.di

import com.wayne.randomuser.data.remote.api.ApiService
import com.wayne.randomuser.data.remote.source.UserRemoteDataSource
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RemoteModule {
    @Provides
    @Singleton
    fun provideUserRemoteDataSource(apiService: ApiService): UserRemoteDataSource {
        return UserRemoteDataSource(apiService)
    }
}