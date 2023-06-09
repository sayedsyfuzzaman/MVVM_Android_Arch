package com.syfuzzaman.mvvm_android_arch.ui.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.extension.observe
import com.syfuzzaman.mvvm_android_arch.model.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private val homeViewModel by viewModels<HomeViewModel>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        observePosts()
        observePopularMovies()
    }

    private fun observePosts(){
        observe(homeViewModel.postsApiResponse){
            when(it){
                is Resource.Success -> {
                    it.data.forEach {
                        Log.d("ObservedList", it.title)
                    }
//                    Log.d("ObservedList", "Data: "+it.data)
                }
                is Resource.Failure ->{
                    Log.d("ObservedList", "Error: "+it.error.code+" "+it.error.msg)
                }
            }
        }
        homeViewModel.postApi()
    }

    private fun observePopularMovies(){
        observe(homeViewModel.popularMoviesResponse){
            when(it){
                is Resource.Success ->{
                    Log.d("ObservedPopularMoviesList", "Data: "+it.data)
                }
                is Resource.Failure ->{
                    Log.d("ObservedPopularMoviesList", "Error: "+it.error.code+" "+it.error.msg)
                }
            }
        }
        homeViewModel.popularMoviesApi()
    }

}