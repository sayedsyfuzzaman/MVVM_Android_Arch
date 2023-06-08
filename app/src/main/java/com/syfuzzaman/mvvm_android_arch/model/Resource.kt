package com.syfuzzaman.mvvm_android_arch.model

import com.google.gson.annotations.SerializedName
import com.syfuzzaman.mvvm_android_arch.data.network.exception.Error

sealed class Resource<out T> {
    data class Success<out T>(
        @SerializedName("data")
        val data: T
    ) : Resource<T>()

    data class Failure<out T>(
        @SerializedName("error")
        val error: Error
    ) : Resource<T>()
}