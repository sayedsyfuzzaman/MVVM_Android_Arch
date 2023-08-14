package com.syfuzzaman.mvvm_android_arch.ui.home.banner

import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.data.network.response.Backdrops
import com.syfuzzaman.mvvm_android_arch.data.network.response.ImageCollectionsResponse
import com.syfuzzaman.mvvm_android_arch.ui.common.BaseListItemCallback
import com.syfuzzaman.mvvm_android_arch.ui.common.MyBaseAdapter

class FeaturedContentAdapter(
    cb: BaseListItemCallback<Backdrops>
) : MyBaseAdapter<Backdrops>(cb) {
    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_featured_content
    }
}