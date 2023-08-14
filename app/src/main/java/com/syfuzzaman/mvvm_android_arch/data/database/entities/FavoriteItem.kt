package com.syfuzzaman.mvvm_android_arch.data.database.entities

import androidx.room.Entity
import com.google.gson.annotations.SerializedName

@Entity
data class FavoriteItem(
    @SerializedName("moviesId")
    var moviesId: Int,
    @SerializedName("categoryId")
    var categoryId: Int,
) : BaseEntity()