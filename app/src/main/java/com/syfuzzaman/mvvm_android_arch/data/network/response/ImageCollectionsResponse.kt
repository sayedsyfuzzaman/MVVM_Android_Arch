package com.syfuzzaman.mvvm_android_arch.data.network.response

import com.google.gson.annotations.SerializedName

data class ImageCollectionsResponse(
    @SerializedName("id") var id: Int? = null,
    @SerializedName("backdrops") var backdrops: List<Backdrops>,
    @SerializedName("posters") var posters: List<Posters>
)

data class Backdrops(

    @SerializedName("aspect_ratio") var aspectRatio: Double? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("iso_639_1") var iso6391: String? = null,
    @SerializedName("file_path") var filePath: String? = null,
    @SerializedName("vote_average") var voteAverage: Double? = null,
    @SerializedName("vote_count") var voteCount: Int? = null,
    @SerializedName("width") var width: Int? = null

)

data class Posters(

    @SerializedName("aspect_ratio") var aspectRatio: Double? = null,
    @SerializedName("height") var height: Int? = null,
    @SerializedName("iso_639_1") var iso6391: String? = null,
    @SerializedName("file_path") var filePath: String? = null,
    @SerializedName("vote_average") var voteAverage: Double? = null,
    @SerializedName("vote_count") var voteCount: Int? = null,
    @SerializedName("width") var width: Int? = null

)