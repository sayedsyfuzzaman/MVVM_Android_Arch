package com.syfuzzaman.mvvm_android_arch.ui.home


import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieResultResponse
import com.syfuzzaman.mvvm_android_arch.ui.common.BaseListItemCallback
import com.syfuzzaman.mvvm_android_arch.ui.common.MyBaseAdapter

class HomeTrendingAdapter(
    cb: BaseListItemCallback<TmdbMovieResultResponse>
): MyBaseAdapter<TmdbMovieResultResponse>(cb){
    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_movie
    }
}