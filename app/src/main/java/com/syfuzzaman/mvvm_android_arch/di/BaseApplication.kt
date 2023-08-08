package com.syfuzzaman.mvvm_android_arch.di

import android.app.Application
import android.util.Log
import com.syfuzzaman.mvvm_android_arch.data.storage.SessionPreference
import dagger.hilt.android.HiltAndroidApp
import javax.inject.Inject

@HiltAndroidApp
class BaseApplication : Application(){
//    @Inject lateinit var sessionPreference: SessionPreference

    override fun onCreate() {
        super.onCreate()
//        SessionPreference.init(this)
//        sessionPreference.isLoggedInFromSubHistory = true
//        Log.d("TAG", "onCreate: ${sessionPreference.isLoggedInFromSubHistory}")
    }
}