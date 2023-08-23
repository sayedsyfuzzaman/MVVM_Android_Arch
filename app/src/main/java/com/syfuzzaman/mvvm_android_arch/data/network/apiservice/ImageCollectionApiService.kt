package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

import com.syfuzzaman.mvvm_android_arch.data.network.response.ImageCollectionsResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.TmdbApi
import javax.inject.Inject

class ImageCollectionApiService @Inject constructor(
    private val tmdbApi: TmdbApi
) {
    suspend fun execute(): ImageCollectionsResponse {
        return tmdbApi.imageCollections(
            collection_id = 10,
        )
    }
}