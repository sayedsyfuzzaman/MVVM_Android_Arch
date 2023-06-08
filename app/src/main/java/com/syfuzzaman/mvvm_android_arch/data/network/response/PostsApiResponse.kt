package com.syfuzzaman.mvvm_android_arch.data.network.response

import com.google.gson.annotations.SerializedName

class PostsApiResponse : ArrayList<PostsApiResponseItem>()
data class PostsApiResponseItem(
    @SerializedName("body")
    var body: String,
    @SerializedName("id")
    var id: Int,
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var userId: Int
)