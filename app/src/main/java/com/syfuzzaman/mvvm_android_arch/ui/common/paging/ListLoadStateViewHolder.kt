package com.syfuzzaman.mvvm_android_arch.ui.common.paging

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.paging.LoadState
import androidx.recyclerview.widget.RecyclerView
import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.databinding.LoadStateFooterViewItemBinding

class ListLoadStateViewHolder(
    private val binding: LoadStateFooterViewItemBinding,
    retry: () -> Unit
) : RecyclerView.ViewHolder(binding.root) {

    /*init {
        binding.retryButton.setOnClickListener { retry.invoke() }
    }*/

    fun bind(loadState: LoadState) {
//        binding.progressBar.isVisible = loadState is LoadState.Loading
        /*if (loadState is LoadState.Error) {
            binding.errorMsg.text = loadState.error.localizedMessage
        }
        binding.retryButton.isVisible = loadState !is LoadState.Loading
        binding.errorMsg.isVisible = loadState !is LoadState.Loading*/
    }

    companion object {
        fun create(parent: ViewGroup, retry: () -> Unit): ListLoadStateViewHolder {
            val view = LayoutInflater.from(parent.context).inflate(R.layout.load_state_footer_view_item, parent, false)
            val binding = LoadStateFooterViewItemBinding.bind(view)
            binding.progressBar.visibility = View.VISIBLE
            return ListLoadStateViewHolder(binding, retry)
        }
    }
}
