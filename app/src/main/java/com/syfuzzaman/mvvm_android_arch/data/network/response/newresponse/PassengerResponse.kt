package com.syfuzzaman.mvvm_android_arch.data.network.response.newresponse

import com.google.gson.annotations.SerializedName

data class PassengerResponse(
    @SerializedName("data")
    val data: List<Data>,
    @SerializedName("totalPages")
    val totalPages: Int,
    @SerializedName("totalPassengers")
    val totalPassengers: Int
)