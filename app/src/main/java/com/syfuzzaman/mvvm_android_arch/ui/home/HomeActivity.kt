package com.syfuzzaman.mvvm_android_arch.ui.home

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import androidx.navigation.findNavController
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.databinding.ActivityHomeBinding
import com.syfuzzaman.mvvm_android_arch.extension.observe
import com.syfuzzaman.mvvm_android_arch.model.Resource
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()


    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val navController = findNavController(R.id.nav_host_fragment_content_home)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)

        observePopularMovies()
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

}