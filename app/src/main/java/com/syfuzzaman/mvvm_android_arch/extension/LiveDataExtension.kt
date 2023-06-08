package com.syfuzzaman.mvvm_android_arch.extension

import androidx.fragment.app.DialogFragment
import androidx.fragment.app.Fragment
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.LiveData

fun <T> LifecycleOwner.observe(liveData: LiveData<T>, body: (T) -> Unit = {}) {
    liveData.observe(if(this is Fragment && this !is DialogFragment) this.viewLifecycleOwner else this) { it?.let { t -> body(t) } }
}