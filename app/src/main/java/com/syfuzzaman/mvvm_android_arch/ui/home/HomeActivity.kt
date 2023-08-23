package com.syfuzzaman.mvvm_android_arch.ui.home

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.WindowCompat
import android.app.Fragment
import android.util.Log
import android.view.Menu
import android.view.View
import android.widget.TextView
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
import com.syfuzzaman.mvvm_android_arch.data.storage.SessionPreference
import com.syfuzzaman.mvvm_android_arch.databinding.ActivityHomeBinding
import com.syfuzzaman.mvvm_android_arch.extension.navigatePopUpTo
import com.syfuzzaman.mvvm_android_arch.extension.navigateTo
import com.syfuzzaman.mvvm_android_arch.extension.observe
import com.syfuzzaman.mvvm_android_arch.model.Resource
import com.syfuzzaman.mvvm_android_arch.util.BindingUtil
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HomeActivity : AppCompatActivity(), NavigationView.OnNavigationItemSelectedListener {
    private lateinit var binding: ActivityHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()
    private lateinit var navController: NavController
    private lateinit var navHostFragment: NavHostFragment
    private lateinit var appbarConfig: AppBarConfiguration
    private var notificationBadge: View? = null
    @Inject lateinit var mPref: SessionPreference
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
//        observeAllTrending("week")
        homeViewModel.popularMoviesApi()
    }

    private fun observeAllTrending(timeWindow: String){
        observe(homeViewModel.trendingApiResponse){
            when(it){
                is Resource.Success ->{
                    Log.d("TMDB_API_LOG", "Data from network: "+it.data)
                }
                is Resource.Failure ->{
                    Log.d("TMDB_API_LOG", "Error from network: "+it.error.code+" - "+it.error.msg)
                }
            }
        }
        homeViewModel.trendingAll(timeWindow)
    }


    private fun setupNavController(){
        navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment_content_home) as NavHostFragment
        navController = navHostFragment.navController

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
        binding.appBar.toolbar.setNavigationIcon(R.drawable.ic_video_logo)
    }


    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_topbar, menu)

        val notificationActionView = menu.findItem(R.id.action_notification)?.actionView
        notificationBadge = notificationActionView?.findViewById<TextView>(R.id.notification_badge)
        notificationActionView?.setOnClickListener {
            if (navController.currentDestination?.id != R.id.notificationFragment) {
                navController.navigateTo(R.id.notificationFragment)
            }
        }

        observeNotification()
        return true
    }

    private fun observeNotification(){
        notificationBadge?.visibility = View.VISIBLE
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        TODO("Not yet implemented")
    }
}