package com.syfuzzaman.mvvm_android_arch.data.network.retrofit

import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface TmdbApi {
    @GET("movie/popular")
    suspend fun popularMovies(
        @Header("Authorization") accessToken:String,
        @Header("accept") accept:String,
        @Query("language") language: String,
        @Query("page") page: Int
    ):TmdbMovieBaseResponse

    @GET("movie/now_playing")
    suspend fun nowPlayingMovies(
        @Header("Authorization") accessToken:String,
        @Header("accept") accept:String,
        @Query("language") language: String,
        @Query("page") page: Int
    ):TmdbMovieBaseResponse

}