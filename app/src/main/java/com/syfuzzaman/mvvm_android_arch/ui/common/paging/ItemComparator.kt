package com.syfuzzaman.mvvm_android_arch.ui.common.paging

import androidx.recyclerview.widget.DiffUtil

class ItemComparator<T: Any>: DiffUtil.ItemCallback<T>() {
    override fun areItemsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }

    override fun areContentsTheSame(oldItem: T, newItem: T): Boolean {
        return oldItem == newItem
    }
}