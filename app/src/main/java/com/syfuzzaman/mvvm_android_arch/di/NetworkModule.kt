package com.syfuzzaman.mvvm_android_arch.di

import com.syfuzzaman.mvvm_android_arch.data.network.ApiConfig
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.ExternalApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.Dns
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {
    @Provides
    @BaseUrlQualifier
    fun providesUrl() = "https://tsports.com/"


    @Provides
    @Singleton
    fun providesApiService(@BaseUrlQualifier url:String) : ExternalApi =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExternalApi::class.java)
}