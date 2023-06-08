package com.syfuzzaman.mvvm_android_arch.data.network.util

import androidx.lifecycle.LiveData
import androidx.lifecycle.liveData
import com.syfuzzaman.mvvm_android_arch.model.Resource
import com.syfuzzaman.mvvm_android_arch.util.getError
import com.syfuzzaman.mvvm_android_arch.util.getExternalError
import kotlinx.coroutines.Dispatchers


fun <T> resultLiveData(networkCall: suspend () -> T): LiveData<Resource<T>> =
    liveData(Dispatchers.IO) {
        try {
            val response = networkCall.invoke()
            emit(Resource.Success(response))
        } catch (e: Exception) {
            emit(Resource.Failure<T>(getError(e)))
        }
    }

suspend fun <T> resultFromResponse(networkCall: suspend () -> T): Resource<T> =
    try {
        val response = networkCall.invoke()
        Resource.Success(response)
    } catch (e: Exception) {
        Resource.Failure<T>(getError(e))
    }

suspend fun <T> resultFromExternalResponse(networkCall: suspend () -> T): Resource<T> =
    try {
        val response = networkCall.invoke()
        Resource.Success(response)
    } catch (e:Exception){
        Resource.Failure(getExternalError(e))
    }