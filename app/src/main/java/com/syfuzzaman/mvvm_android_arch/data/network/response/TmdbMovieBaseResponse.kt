package com.syfuzzaman.mvvm_android_arch.data.network.response

import com.google.gson.annotations.SerializedName

data class TmdbMovieBaseResponse (
    @SerializedName("page")
    val page: Int,

    @SerializedName("total_pages")
    val total_pages: Int,

    @SerializedName("results")
    val results: List<TmdbMovieResultResponse>,


    @SerializedName("total_results")
    val total_results: Int,
)