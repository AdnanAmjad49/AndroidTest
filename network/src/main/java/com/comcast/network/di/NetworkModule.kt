package com.comcast.network.di

import android.app.Application
import com.comcast.network.BuildConfig
import com.comcast.network.constant.NetworkConstant.API_KEY
import com.comcast.network.constant.NetworkConstant.BASE_URL
import com.comcast.network.constant.NetworkConstant.CACHE_CONTROL
import com.comcast.network.constant.NetworkConstant.CACHE_FILE_NAME
import com.comcast.network.constant.NetworkConstant.CONTENT_TYPE
import com.comcast.network.constant.NetworkConstant.CONTENT_TYPE_VALUE
import com.comcast.network.constant.NetworkConstant.MAX_AGE
import com.comcast.network.constant.NetworkConstant.MAX_AGE_CACHE
import com.comcast.network.constant.NetworkConstant.MAX_CACHE_SIZE
import com.comcast.network.constant.NetworkConstant.MAX_STALE
import com.comcast.network.constant.NetworkConstant.MIN_AGE_CACHE
import com.comcast.network.constant.NetworkConstant.TIMEOUT
import com.comcast.network.core.ApiService
import com.comcast.network.util.NetworkUtil.isNetworkConnected
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.io.File
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun providesOkHttp(application: Application): OkHttpClient = OkHttpClient.Builder().apply {
        if (BuildConfig.DEBUG) {
            addInterceptor(HttpLoggingInterceptor().apply {
                level = HttpLoggingInterceptor.Level.BODY
            })
        }
        val headerInterceptor = Interceptor { chain: Interceptor.Chain ->
            var request = chain.request()
            request = if (application.isNetworkConnected()) {
                request.newBuilder()
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .header(CACHE_CONTROL, "$MAX_AGE$MIN_AGE_CACHE")
                    .header(API_KEY, BuildConfig.apiKey)
                    .build()
            } else {
                request.newBuilder()
                    .header(CONTENT_TYPE, CONTENT_TYPE_VALUE)
                    .header(CACHE_CONTROL, "$MAX_STALE$MAX_AGE_CACHE")
                    .header(API_KEY, BuildConfig.apiKey)
                    .build()
            }

            chain.proceed(request)
        }
        val cache = Cache(File(application.cacheDir, CACHE_FILE_NAME), MAX_CACHE_SIZE.toLong())
        cache(cache)
        addInterceptor(headerInterceptor)
        connectTimeout(TIMEOUT, TimeUnit.SECONDS)
        writeTimeout(TIMEOUT, TimeUnit.SECONDS)
        readTimeout(TIMEOUT, TimeUnit.SECONDS)
    }.build()

    @Provides
    @Singleton
    fun providesRetrofit(okHttpClient: OkHttpClient): Retrofit = Retrofit.Builder().apply {
        baseUrl(BASE_URL)
        client(okHttpClient)
        addConverterFactory(GsonConverterFactory.create())
    }.build()

    @Singleton
    @Provides
    fun provideApi(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}