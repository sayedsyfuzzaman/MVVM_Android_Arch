package com.syfuzzaman.mvvm_android_arch.data.network.inercetor

import android.util.Log
import com.syfuzzaman.mvvm_android_arch.BuildConfig
import okhttp3.Interceptor
import okhttp3.Response

class CustomLoggingInterceptor(private val includeHeaders: Boolean) : Interceptor {

    override fun intercept(chain: Interceptor.Chain): Response {
        val request = chain.request()

        val modifiedRequest = if (includeHeaders) {
            request.newBuilder()
                .addHeader("Authorization", BuildConfig.TMDB_ACCESS_TOKEN)
                .addHeader("accept", "application/json")
                .build()
        } else {
            request
        }

        val url = modifiedRequest.url.toString()
        Log.d("API_LOG", "Method: ${modifiedRequest.method} URL: $url")

        return chain.proceed(modifiedRequest)
    }
}

