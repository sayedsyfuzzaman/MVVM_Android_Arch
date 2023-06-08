package com.syfuzzaman.mvvm_android_arch.di

import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.ExternalApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

//@Module
//@InstallIn(SingletonComponent::class)
//object AppModule {
//
//
//}