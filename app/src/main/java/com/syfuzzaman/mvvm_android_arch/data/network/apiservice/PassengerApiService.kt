package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

import com.syfuzzaman.mvvm_android_arch.data.network.response.PostsApiResponse
import com.syfuzzaman.mvvm_android_arch.data.network.response.newresponse.PassengerResponse
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.ExternalApi
import javax.inject.Inject

class PassengerApiService @Inject constructor(
    private val externalApi: ExternalApi
){
    suspend fun execute(): PassengerResponse {
        return externalApi.passengerApi(
            url = "https://api.instantwebtools.net/v1/passenger?page=0&size=5"
        )
    }
}