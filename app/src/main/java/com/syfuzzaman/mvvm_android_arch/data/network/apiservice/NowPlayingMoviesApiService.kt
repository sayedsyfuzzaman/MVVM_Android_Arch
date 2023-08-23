package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import javax.inject.Inject

class NowPlayingMoviesApiService @Inject constructor(
    private val tmdbApi: TmdbApi
) {

    suspend fun execute(): TmdbMovieBaseResponse {
        return tmdbApi.nowPlayingMovies(
            page = 1,
            language = "en-US"
        )
    }

}