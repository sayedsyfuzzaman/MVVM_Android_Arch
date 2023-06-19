package com.syfuzzaman.mvvm_android_arch.data.network.response.newresponse

import com.google.gson.annotations.SerializedName

data class Data(
    @SerializedName("__v")
    val __v: Int,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("airline")
    val airline: List<Airline>,
    @SerializedName("name")
    val name: String,
    @SerializedName("trips")
    val trips: Int
)