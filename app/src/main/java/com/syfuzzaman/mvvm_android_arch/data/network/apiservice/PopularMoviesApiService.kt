package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import javax.inject.Inject

class PopularMoviesApiService @Inject constructor(
    private val tmdbApi: TmdbApi
) {
    suspend fun execute(): TmdbMovieBaseResponse{
        return tmdbApi.popularMovies(
            page = 1,
            language = "en-US"
        )
    }
}