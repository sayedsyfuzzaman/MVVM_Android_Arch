package com.syfuzzaman.mvvm_android_arch.data.network.retrofit

import com.syfuzzaman.mvvm_android_arch.data.network.response.ImageCollectionsResponse
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbPeopleBaseResponse
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Path
import retrofit2.http.Query

interface  TmdbApi {
    @GET("movie/popular")
    suspend fun popularMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ):TmdbMovieBaseResponse

    @GET("movie/now_playing")
    suspend fun nowPlayingMovies(
        @Query("language") language: String,
        @Query("page") page: Int
    ):TmdbMovieBaseResponse

    @GET("trending/all/{time_window}")
    suspend fun allTrending(
        @Path("time_window") time_window: String,
        @Query("language") language: String
    ):TmdbMovieBaseResponse

    @GET("person/popular")
    suspend fun popularPeoples(
        @Query("language") language: String,
        @Query("page") page: Int,
    ):TmdbPeopleBaseResponse

    @GET("collection/{collection_id}/images")
    suspend fun imageCollections(
        @Path("collection_id") collection_id: Int
    ): ImageCollectionsResponse

}