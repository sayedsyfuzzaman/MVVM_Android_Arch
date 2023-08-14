package com.syfuzzaman.mvvm_android_arch.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.syfuzzaman.mvvm_android_arch.data.database.dao.FavoriteItemDao
import com.syfuzzaman.mvvm_android_arch.data.database.entities.FavoriteItem

@Database(
    entities = [
        FavoriteItem::class
    ],
    version = 1,
    exportSchema = false
)

abstract class MyDatabase : RoomDatabase() {
    companion object {
        const val DB_NAME = "my-db"
    }

    abstract fun getFavoriteItemsDao(): FavoriteItemDao
}