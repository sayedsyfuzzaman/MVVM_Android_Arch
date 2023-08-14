package com.syfuzzaman.mvvm_android_arch.di

import android.content.Context
import androidx.room.Room
import com.syfuzzaman.mvvm_android_arch.data.database.MigrationProvider
import com.syfuzzaman.mvvm_android_arch.data.database.MyDatabase
import com.syfuzzaman.mvvm_android_arch.data.database.dao.FavoriteItemDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext app: Context): MyDatabase {
        return Room.databaseBuilder(app,
            MyDatabase::class.java, MyDatabase.DB_NAME)
//            .addMigrations(*MigrationProvider.getMigrationList().toTypedArray())
//            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun providesFavoritesItemDao(db: MyDatabase): FavoriteItemDao {
        return db.getFavoriteItemsDao()
    }
}