package com.wayne.randomuser.data.remote.di

import com.wayne.randomuser.data.remote.source.UserRemoteDataSource
import com.wayne.randomuser.data.repository.UserRepositoryImpl
import com.wayne.randomuser.domain.repository.UserRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    @Singleton
    fun provideUserRepository(userRemoteDataSource: UserRemoteDataSource): UserRepository {
        return UserRepositoryImpl(userRemoteDataSource)
    }
}