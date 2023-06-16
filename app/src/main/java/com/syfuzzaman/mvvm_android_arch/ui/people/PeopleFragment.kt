package com.syfuzzaman.mvvm_android_arch.ui.people

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.lifecycleScope
import androidx.paging.LoadState
import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.data.network.response.PeopleKnownFor
import com.syfuzzaman.mvvm_android_arch.databinding.FragmentPeopleBinding
import com.syfuzzaman.mvvm_android_arch.extension.observe
import com.syfuzzaman.mvvm_android_arch.ui.common.BaseListItemCallback

class PeopleFragment : Fragment(), BaseListItemCallback<PeopleKnownFor> {
    private lateinit var mAdapter: PeopleContentAdapter
    private lateinit var binding: FragmentPeopleBinding
    private val peopleViewModel by activityViewModels<PeopleViewModel>()
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentPeopleBinding.inflate(inflater, container, false)
        return binding.root
    }
}