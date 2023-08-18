package com.syfuzzaman.mvvm_android_arch.data.network.inercetor

import android.util.Log
import okhttp3.Interceptor
import okhttp3.Response

class CustomLoggingInterceptor : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()
        val url = request.url.toString()

        Log.d("API_LOG", "Request URL: $url")

        return chain.proceed(request)
    }
}
