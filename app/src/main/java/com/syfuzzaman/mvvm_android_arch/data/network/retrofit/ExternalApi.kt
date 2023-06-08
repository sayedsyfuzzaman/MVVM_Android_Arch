package com.syfuzzaman.mvvm_android_arch.data.network.retrofit

import com.syfuzzaman.mvvm_android_arch.data.network.response.PostsApiResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ExternalApi {

    @GET
    suspend fun postsApi(
        @Url url:String
    ):PostsApiResponse
}