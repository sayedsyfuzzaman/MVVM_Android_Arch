package com.syfuzzaman.mvvm_android_arch.di

import com.syfuzzaman.mvvm_android_arch.data.network.inercetor.CustomLoggingInterceptor
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.ExternalApi
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    @Provides
    fun Url() = "https://sample.com/"

    @Provides
    @BaseUrlQualifier
    fun providesUrl() = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    @TmdbOkHttpQualifier
    fun provideOkHttpClientTmdb(): OkHttpClient {
        val customInterceptor = CustomLoggingInterceptor(includeHeaders = true)
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Log response body
        }
        return OkHttpClient.Builder()
            .addInterceptor(customInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    @ExternalOkHttpQualifier
    fun provideOkHttpClientExternal(): OkHttpClient {
        val customInterceptor = CustomLoggingInterceptor(includeHeaders = false)
        val loggingInterceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY // Log response body
        }
        return OkHttpClient.Builder()
            .addInterceptor(customInterceptor)
            .addInterceptor(loggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesTmdbApiService(
        @BaseUrlQualifier url: String,
        @TmdbOkHttpQualifier okHttpClient: OkHttpClient
    ): TmdbApi =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient) // Use the appropriate OkHttpClient
            .build()
            .create(TmdbApi::class.java)

    @Provides
    @Singleton
    fun providesExternalApiService(
        url: String,
        @BaseUrlQualifier baseUrl: String,
        @ExternalOkHttpQualifier okHttpClientExternal: OkHttpClient
    ): ExternalApi =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClientExternal) // Use the appropriate OkHttpClient
            .build()
            .create(ExternalApi::class.java)
}