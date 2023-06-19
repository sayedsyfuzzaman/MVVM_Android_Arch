package com.syfuzzaman.mvvm_android_arch.data.network.response.newresponse

import com.google.gson.annotations.SerializedName

data class Airline(
    @SerializedName("__v")
    val __v: Int,
    @SerializedName("_id")
    val _id: String,
    @SerializedName("country")
    val country: String,
    @SerializedName("established")
    val established: String,
    @SerializedName("head_quaters")
    val head_quaters: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("logo")
    val logo: String,
    @SerializedName("name")
    val name: String,
    @SerializedName("slogan")
    val slogan: String,
    @SerializedName("website")
    val website: String
)