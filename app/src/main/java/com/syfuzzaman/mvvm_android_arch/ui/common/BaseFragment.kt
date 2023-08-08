package com.syfuzzaman.mvvm_android_arch.ui.common

import androidx.fragment.app.Fragment
import com.syfuzzaman.mvvm_android_arch.data.storage.SessionPreference
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
open class BaseFragment : Fragment() {
    @Inject lateinit var mPref: SessionPreference
}