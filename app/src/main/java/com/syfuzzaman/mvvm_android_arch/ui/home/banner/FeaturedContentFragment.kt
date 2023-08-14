package com.syfuzzaman.mvvm_android_arch.ui.home.banner

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import com.google.android.material.tabs.TabLayoutMediator
import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.data.network.response.Backdrops
import com.syfuzzaman.mvvm_android_arch.databinding.FragmentFeaturedContentBinding
import com.syfuzzaman.mvvm_android_arch.extension.observe
import com.syfuzzaman.mvvm_android_arch.extension.show
import com.syfuzzaman.mvvm_android_arch.model.Resource
import com.syfuzzaman.mvvm_android_arch.ui.common.BaseFragment
import com.syfuzzaman.mvvm_android_arch.ui.common.BaseListItemCallback
import com.syfuzzaman.mvvm_android_arch.ui.home.HomeViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.isActive
import kotlinx.coroutines.launch

class FeaturedContentFragment : BaseFragment(), BaseListItemCallback<Backdrops> {
    private var slideJob: Job? = null
    private lateinit var mAdapter: FeaturedContentAdapter
    private var _binding: FragmentFeaturedContentBinding? = null
    private val binding get() = _binding!!
    private val viewModel by activityViewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentFeaturedContentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.featuredJob?.cancel()
        viewModel.featuredJob = null
        mAdapter = FeaturedContentAdapter(this)
        binding.featuredViewpager.adapter = mAdapter
        TabLayoutMediator(
            binding.featuredIndicator,
            binding.featuredViewpager,
            true
        ) { _, _ -> }.attach()
        observeImageCollections()
    }

    private fun observeImageCollections() {
        observe(viewModel.imageCollectionsResponse) {
            when (it) {
                is Resource.Success -> {

                    var c = 0
                    val result = ArrayList<Backdrops>(6)

                    for (item in it.data.backdrops) {
                        if (c < 5) {
                            result.add(item)
                            c++
                        }
                    }

                    result.let {
                        mAdapter.removeAll()
                        mAdapter.addAll(it)
                        startPageScroll()
                        binding.featuredViewpager.show()
                    }
                    Log.d("TMDB_IMAGE_LOG", "Image Collection: $it")
                }

                is Resource.Failure -> {
                    Log.d(
                        "TMDB_IMAGE_LOG",
                        "Error from network: " + it.error.code + " - " + it.error.msg
                    )
                }
            }
        }
        viewModel.imageCollections()
    }

    private fun startPageScroll() {
        slideJob?.cancel()
        slideJob = lifecycleScope.launch {
            while (isActive) {
                delay(5000)
                if (isActive && mAdapter.itemCount > 0) {
                    binding.featuredViewpager.currentItem =
                        (binding.featuredViewpager.currentItem + 1) % mAdapter.itemCount
                }
            }
        }
    }

    override fun onDestroyView() {
        slideJob?.cancel()
        binding.featuredViewpager.adapter = null
        super.onDestroyView()
        _binding = null
    }
}