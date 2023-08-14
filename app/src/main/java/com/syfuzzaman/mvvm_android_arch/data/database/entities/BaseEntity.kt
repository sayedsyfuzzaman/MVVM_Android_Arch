package com.syfuzzaman.mvvm_android_arch.data.database.entities

import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

abstract class BaseEntity {
    @SerializedName("id")
    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    @SerializedName("createTime")
    var createTime: Long = System.currentTimeMillis()
    @SerializedName("updateTime")
    var updateTime: Long = System.currentTimeMillis()
}