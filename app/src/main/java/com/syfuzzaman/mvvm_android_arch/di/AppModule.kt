package com.syfuzzaman.mvvm_android_arch.di

import android.content.Context
import android.content.SharedPreferences
import com.syfuzzaman.mvvm_android_arch.data.network.retrofit.ExternalApi
import com.syfuzzaman.mvvm_android_arch.data.storage.PREF_NAME_MVVM_ARCH
import com.syfuzzaman.mvvm_android_arch.data.storage.SessionPreference
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import javax.inject.Singleton
import retrofit2.converter.gson.GsonConverterFactory

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    fun providesSessionSharedPreference(@ApplicationContext app: Context): SharedPreferences {
        return app.getSharedPreferences(PREF_NAME_MVVM_ARCH, Context.MODE_PRIVATE)
    }

    @Provides
    @Singleton
    fun providesPreference(pref: SharedPreferences, @ApplicationContext ctx: Context): SessionPreference {
        return SessionPreference(pref, ctx)
    }

}