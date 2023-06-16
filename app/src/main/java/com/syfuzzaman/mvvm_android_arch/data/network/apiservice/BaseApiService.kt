package com.syfuzzaman.mvvm_android_arch.data.network.apiservice

interface BaseApiService<T: Any> {
    suspend fun loadData(offset: Int, limit: Int): List<T>
}