package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbPeopleBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import javax.inject.Inject

class PopularPeopleApiService @Inject constructor(
    val tmdbApi: TmdbApi
) {
    suspend fun execute(page: Int): TmdbPeopleBaseResponse{
        return tmdbApi.popularPeoples(
            page = page,
            language = "en-US"
        )
    }
}