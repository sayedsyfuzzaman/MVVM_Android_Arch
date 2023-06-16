package com.syfuzzaman.mvvm_android_arch.data.network.response

import com.google.gson.annotations.SerializedName

data class TmdbPeopleBaseResponse(
    @SerializedName("page")
    val page: Int,
    @SerializedName("results")
    val results: List<TmdbPeopleResultResponse>,
    @SerializedName("total_pages")
    val total_pages: Int,
    @SerializedName("total_results")
    val total_results: Int
)