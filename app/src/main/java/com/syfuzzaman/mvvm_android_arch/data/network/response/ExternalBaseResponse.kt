package com.syfuzzaman.mvvm_android_arch.data.network.response

import com.google.gson.annotations.SerializedName

open class ExternalBaseResponse {
    @SerializedName("statusCode")
    var statusCode: Int = 200

    @SerializedName("errorCode")
    var errorCode: Int = 0

    @SerializedName("errorMsg")
    var errorMsg: String? = null

}