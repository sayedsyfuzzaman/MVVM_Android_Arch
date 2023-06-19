package com.syfuzzaman.mvvm_android_arch.ui.home

import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import android.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.google.android.material.navigation.NavigationView
import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.databinding.ActivityHomeBinding
import com.syfuzzaman.mvvm_android_arch.extension.navigatePopUpTo
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var navController: NavController
    private lateinit var appbarConfig: AppBarConfiguration
    override fun onCreate(savedInstanceState: Bundle?) {
        WindowCompat.setDecorFitsSystemWindows(window, false)
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        setSupportActionBar(binding.appBar.toolbar)
        supportActionBar?.setHomeButtonEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        setupNavController()
//        supportActionBar?.title = "TMDB HOME"


    }

//    override fun onSupportNavigateUp(): Boolean {
//        return NavigationUI.navigateUp(navController, appbarConfig) || super.onSupportNavigateUp()
//    }


    private fun setupNavController(){
        navController = findNavController(R.id.nav_host_fragment_content_home)
        val bottomNavigationView = findViewById<BottomNavigationView>(R.id.bottomNavigationView)
        bottomNavigationView.setupWithNavController(navController)

        binding.appBar.toolbar.setNavigationOnClickListener{
            val navOptions = NavOptions.Builder()
                .setPopUpTo(R.id.homeFragment, true)
                .build()
            navController.navigate(R.id.homeFragment, null, navOptions)
        }

        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.homeFragment -> {
                    navController.navigate(R.id.homeFragment)
                    true
                }
                R.id.moviesFragment -> {
                    navController.navigate(R.id.moviesFragment)
                    true
                }
                R.id.tvshowFragment -> {
                    navController.navigate(R.id.tvshowFragment)
                    true
                }
                R.id.peopleFragment -> {
                    navController.navigate(R.id.peopleFragment)
                    true
                }
                // Add cases for other menu items as needed
                else -> false
            }
        }
//
//        binding.appBar.toolbar.setupWithNavController(navController, appbarConfig)
//        binding.appBar.toolbar.setNavigationIcon(R.drawable.ic_video_logo)
//        binding.appBar.toolbar.title = "TMDB HOME"
        binding.appBar.toolbar.setNavigationIcon(R.drawable.ic_video_logo)

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")

    }


}