package com.syfuzzaman.mvvm_android_arch.data.network.response

import com.google.gson.annotations.SerializedName

data class TmdbMovieBaseResponse (
    @SerializedName("dates")
    val dates: Dates? = null,

    @SerializedName("page")
    val page: Int?,

    @SerializedName("total_pages")
    val total_pages: Int?,

    @SerializedName("results")
    val results: List<TmdbMovieResultResponse>,


    @SerializedName("total_results")
    val total_results: Int?,
)

data class Dates(
    @SerializedName("maximum")
    val maximum: String,
    @SerializedName("minimum")
    val minimum: String
)
