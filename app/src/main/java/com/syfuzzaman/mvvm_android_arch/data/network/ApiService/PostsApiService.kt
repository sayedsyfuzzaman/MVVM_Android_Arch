package com.syfuzzaman.mvvm_android_arch.data.network.ApiService

import com.syfuzzaman.mvvm_android_arch.data.network.response.PostsApiResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.ExternalApi
import javax.inject.Inject

class PostsApiService @Inject constructor(
    private val externalApi: ExternalApi
){
    suspend fun execute(): PostsApiResponse{
        return externalApi.postsApi(
            url = "https://jsonplaceholder.typicode.com/posts"
        )
    }
}