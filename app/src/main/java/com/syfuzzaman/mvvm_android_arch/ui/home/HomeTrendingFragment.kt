package com.syfuzzaman.mvvm_android_arch.ui.home

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieResultResponse
import com.syfuzzaman.mvvm_android_arch.databinding.FragmentHomeTrendingBinding
import com.syfuzzaman.mvvm_android_arch.extension.observe
import com.syfuzzaman.mvvm_android_arch.model.Resource
import com.syfuzzaman.mvvm_android_arch.ui.common.BaseListItemCallback
import com.syfuzzaman.mvvm_android_arch.util.MarginItemDecoration


class HomeTrendingFragment : Fragment(), BaseListItemCallback<TmdbMovieResultResponse> {
    private lateinit var binding: FragmentHomeTrendingBinding
    private lateinit var mAdapter: HomeTrendingAdapter
    private val homeViewModel by activityViewModels<HomeViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeTrendingBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.progressBar.visibility = View.VISIBLE

        mAdapter = HomeTrendingAdapter(this)
        val linearLayoutManager = object : LinearLayoutManager(context, HORIZONTAL, false) {
            override fun onLayoutCompleted(state: RecyclerView.State?) {
                super.onLayoutCompleted(state)
            }
        }
        with(binding.rvHomeTrendingList) {
            adapter = mAdapter
            layoutManager = linearLayoutManager
            addItemDecoration(MarginItemDecoration(12))
        }


        binding.radioGroupTrending.setOnCheckedChangeListener { group, checkedId -> // Handle radio button selection change here
            when (checkedId) {
                com.syfuzzaman.mvvm_android_arch.R.id.radioBtnToday -> {
                    observeAllTrending("day")
                }
                com.syfuzzaman.mvvm_android_arch.R.id.radioBtnThisWeek -> {
                    observeAllTrending("week")
                }
            }
        }

        observeAllTrending("day")
    }

    override fun onDestroyView() {
        super.onDestroyView()
        binding.rvHomeTrendingList.adapter = null
    }

    private fun observeAllTrending(timeWindow: String){
        observe(homeViewModel.trendingApiResponse){
            when(it){
                is Resource.Success ->{
                    Log.d("TMDB_API_LOG", "Data from network: "+it.data)
                    binding.progressBar.visibility = View.GONE
                    it.data.let { dataList ->
                        mAdapter.removeAll()
                        mAdapter.addAll(dataList.results ?: emptyList())
                    }
                }
                is Resource.Failure ->{
                    Log.d("TMDB_API_LOG", "Error from network: "+it.error.code+" - "+it.error.msg)
                }
            }
        }
        homeViewModel.trendingAll(timeWindow)
    }
}