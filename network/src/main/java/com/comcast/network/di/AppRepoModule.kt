package com.comcast.network.di

import com.comcast.network.core.ApiService
import com.comcast.network.repo.ApiRepository
import com.comcast.network.repo.ApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppRepoModule {
    @Provides
    fun providesApiRepository(apiService: ApiService): ApiRepository = ApiRepositoryImpl(apiService)
}