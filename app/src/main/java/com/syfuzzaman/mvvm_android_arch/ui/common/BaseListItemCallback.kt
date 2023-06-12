package com.syfuzzaman.mvvm_android_arch.ui.common

import android.view.View

interface BaseListItemCallback<T: Any> {
    fun onItemClicked(item: T) {}
    fun onOpenMenu(view: View, item: T) {}
    fun onShareClicked(view: View, item: T) {}
    fun onItemClick() {}
}