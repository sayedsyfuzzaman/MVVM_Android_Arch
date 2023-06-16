package com.syfuzzaman.mvvm_android_arch.ui.common.paging

import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.RecyclerView
import com.syfuzzaman.mvvm_android_arch.BR

class BaseViewHolder(val binding: ViewDataBinding)
    :RecyclerView.ViewHolder(binding.root) {

    fun bind(obj: Any, callback: Any?, position: Int, selected: Any? = null) {
        binding.setVariable(BR.callback, callback)
//        binding.setVariable(BR.position, position)
        binding.setVariable(BR.data, obj)
        if(selected != null) {
//            binding.setVariable(BR.selectedItem, selected)
        }

        binding.executePendingBindings()
    }
}