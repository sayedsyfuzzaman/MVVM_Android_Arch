package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

import com.syfuzzaman.mvvm_android_arch.data.network.ApiConfig
import com.syfuzzaman.mvvm_android_arch.data.network.response.ImageCollectionsResponse
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import javax.inject.Inject

class ImageCollectionApiService @Inject constructor(
    private val tmdbApi: TmdbApi
) {

    suspend fun execute(): ImageCollectionsResponse {

        val apiConfig = ApiConfig()
        return tmdbApi.imageCollections(
            accessToken = apiConfig.tmdbAccessToken,
            accept = "application/json",
            collection_id = 10,
        )
    }

}