package com.syfuzzaman.mvvm_android_arch.data.network.retrofit

import com.syfuzzaman.mvvm_android_arch.data.network.response.PostsApiResponse
import com.syfuzzaman.mvvm_android_arch.data.network.response.newresponse.PassengerResponse
import retrofit2.http.GET
import retrofit2.http.Query
import retrofit2.http.Url

interface ExternalApi {

    @GET
    suspend fun postsApi(
        @Url url:String
    ):PostsApiResponse

    @GET
    suspend fun passengerApi(
        @Url url: String
    ):PassengerResponse
}