package com.syfuzzaman.mvvm_android_arch.ui.home

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.syfuzzaman.mvvm_android_arch.data.network.apiservice.ImageCollectionApiService
import com.syfuzzaman.mvvm_android_arch.data.network.apiservice.NowPlayingMoviesApiService
import com.syfuzzaman.mvvm_android_arch.data.network.apiservice.PassengerApiService
import com.syfuzzaman.mvvm_android_arch.data.network.apiservice.PopularMoviesApiService
import com.syfuzzaman.mvvm_android_arch.data.network.apiservice.PostsApiService
import com.syfuzzaman.mvvm_android_arch.data.network.apiservice.TrendingApiService
import com.syfuzzaman.mvvm_android_arch.data.network.response.ImageCollectionsResponse
import com.syfuzzaman.mvvm_android_arch.data.network.response.PostsApiResponse
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieBaseResponse
import com.syfuzzaman.mvvm_android_arch.data.network.response.newresponse.PassengerResponse
import com.syfuzzaman.mvvm_android_arch.data.network.util.SingleLiveEvent
import com.syfuzzaman.mvvm_android_arch.data.network.util.resultFromExternalResponse
import com.syfuzzaman.mvvm_android_arch.model.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import java.security.PrivateKey
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val postApiService: PostsApiService,
    private val popularMoviesApiService: PopularMoviesApiService,
    private val nowPlayingMoviesApiService: NowPlayingMoviesApiService,
    private val trendingApiService: TrendingApiService,
    private val passengerApiService: PassengerApiService,
    private val imageCollectionApiService: ImageCollectionApiService
): ViewModel()
{
    var featuredJob: Job? = null
    val postsApiResponse = SingleLiveEvent<Resource<PostsApiResponse>>()
    val popularMoviesResponse = SingleLiveEvent<Resource<TmdbMovieBaseResponse>>()
    val nowPlayingMoviesResponse = SingleLiveEvent<Resource<TmdbMovieBaseResponse>>()
    val trendingApiResponse = SingleLiveEvent<Resource<TmdbMovieBaseResponse>>()
    val passengerResponse = SingleLiveEvent<Resource<PassengerResponse>>()
    val imageCollectionsResponse = SingleLiveEvent<Resource<ImageCollectionsResponse>>()

    fun postApi(){
        viewModelScope.launch {
            val response = resultFromExternalResponse { postApiService.execute() }
            postsApiResponse.value = response
        }
    }

    fun passengerApi(){
        viewModelScope.launch {
            val response = resultFromExternalResponse { passengerApiService.execute() }
            passengerResponse.value = response
        }
    }

    fun popularMoviesApi(){
        viewModelScope.launch {
            val response = resultFromExternalResponse { popularMoviesApiService.execute() }
            popularMoviesResponse.value = response
        }
    }

    fun nowPlayingMovie(){
        viewModelScope.launch {
            val response = resultFromExternalResponse { nowPlayingMoviesApiService.execute() }
            nowPlayingMoviesResponse.value = response
        }
    }

    fun trendingAll(timeWindow: String){
        viewModelScope.launch {
            val response = resultFromExternalResponse { trendingApiService.execute(timeWindow) }
            trendingApiResponse.value = response
        }
    }

    fun imageCollections(){
        viewModelScope.launch {
            val response= resultFromExternalResponse { imageCollectionApiService.execute() }
            imageCollectionsResponse.value = response
        }
    }
}