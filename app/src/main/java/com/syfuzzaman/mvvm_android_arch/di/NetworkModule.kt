package com.syfuzzaman.mvvm_android_arch.di

import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.ExternalApi
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
object NetworkModule {

    //EXTERNAL API RETROFIT SERVICE START
    @Provides
    fun Url() = "https://sample.com/"

    @Provides
    @Singleton
    fun providesExternalApiService(url:String) : ExternalApi =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(ExternalApi::class.java)

    //EXTERNAL API RETROFIT SERVICE START





    // TMDB API RETROFIT SERVICE START
    @Provides
    @BaseUrlQualifier
    fun providesUrl() = "https://api.themoviedb.org/3/"

    @Provides
    @Singleton
    fun providesTmdbApiService(@BaseUrlQualifier url:String) : TmdbApi =
        Retrofit.Builder()
            .baseUrl(url)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
            .create(TmdbApi::class.java)
    // TMDB API RETROFIT SERVICE END
}