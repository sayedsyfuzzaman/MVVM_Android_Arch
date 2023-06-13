package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

import com.syfuzzaman.mvvm_android_arch.data.network.ApiConfig
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import javax.inject.Inject

class TrendingApiService @Inject constructor(
    private val tmdbApi: TmdbApi
) {

    suspend fun execute(timeWindow: String): TmdbMovieBaseResponse {
        val apiConfig = ApiConfig()

        return tmdbApi.allTrending(
            accessToken = apiConfig.tmdbAccessToken,
            accept = "application/json",
            language = "en-US",
            time_window = timeWindow
        )
    }
}