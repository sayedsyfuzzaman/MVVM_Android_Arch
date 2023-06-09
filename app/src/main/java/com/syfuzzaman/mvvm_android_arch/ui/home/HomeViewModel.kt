package com.syfuzzaman.mvvm_android_arch.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syfuzzaman.mvvm_android_arch.data.network.ApiService.PopularMoviesApiService
import com.syfuzzaman.mvvm_android_arch.data.network.ApiService.PostsApiService
import com.syfuzzaman.mvvm_android_arch.data.network.response.PostsApiResponse
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.util.SingleLiveEvent
import com.syfuzzaman.mvvm_android_arch.data.network.util.resultFromExternalResponse
import com.syfuzzaman.mvvm_android_arch.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postApiService: PostsApiService,
    private val popularMoviesApiService: PopularMoviesApiService
): ViewModel()
{
    val postsApiResponse = SingleLiveEvent<Resource<PostsApiResponse>>()
    val popularMoviesResponse = SingleLiveEvent<Resource<TmdbMovieBaseResponse>>()

    fun postApi(){
        viewModelScope.launch {
            val response = resultFromExternalResponse { postApiService.execute() }
            postsApiResponse.value = response
        }
    }

    fun popularMoviesApi(){
        viewModelScope.launch {
            val response = resultFromExternalResponse { popularMoviesApiService.execute() }
            popularMoviesResponse.value = response
        }
    }
}