package com.comcast.network.di

import android.app.Application
import android.content.Context
import com.comcast.network.core.ApiService
import com.comcast.network.repo.ApiRepository
import com.comcast.network.repo.ApiRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class AppModule {
    @Provides
    fun providesContext(application: Application): Context = application.applicationContext
}