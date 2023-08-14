package com.syfuzzaman.mvvm_android_arch.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.syfuzzaman.mvvm_android_arch.data.database.entities.FavoriteItem

@Dao
interface FavoriteItemDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(item: FavoriteItem): Long

    @Delete
    suspend fun delete(item: FavoriteItem)

    @Query("DELETE FROM FavoriteItem")
    suspend fun deleteAll()
}