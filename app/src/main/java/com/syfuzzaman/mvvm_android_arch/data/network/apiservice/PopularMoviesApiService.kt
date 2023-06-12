package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

import com.syfuzzaman.mvvm_android_arch.data.network.ApiConfig
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import javax.inject.Inject

class PopularMoviesApiService @Inject constructor(
    private val tmdbApi: TmdbApi
) {
    suspend fun execute(): TmdbMovieBaseResponse{

        val apiConfig = ApiConfig()

        return tmdbApi.popularMovies(
            accessToken =apiConfig.tmdbAccessToken,
            accept = "application/json",
            page = 1,
            language = "en-US"
        )
    }
}