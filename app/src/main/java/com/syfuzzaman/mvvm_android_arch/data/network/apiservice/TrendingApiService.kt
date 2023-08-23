package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import javax.inject.Inject

class TrendingApiService @Inject constructor(
    private val tmdbApi: TmdbApi
) {

    suspend fun execute(timeWindow: String): TmdbMovieBaseResponse {
        return tmdbApi.allTrending(
            language = "en-US",
            time_window = timeWindow
        )
    }
}