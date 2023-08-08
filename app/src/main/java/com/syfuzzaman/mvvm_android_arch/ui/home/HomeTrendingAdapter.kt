package com.syfuzzaman.mvvm_android_arch.ui.home


import android.widget.ImageView
import coil.load
import coil.size.Scale
import com.syfuzzaman.mvvm_android_arch.R
import com.syfuzzaman.mvvm_android_arch.data.network.response.TmdbMovieResultResponse
import com.syfuzzaman.mvvm_android_arch.ui.common.BaseListItemCallback
import com.syfuzzaman.mvvm_android_arch.ui.common.MyBaseAdapter
import com.syfuzzaman.mvvm_android_arch.ui.common.MyViewHolder

class HomeTrendingAdapter(
    cb: BaseListItemCallback<TmdbMovieResultResponse>
): MyBaseAdapter<TmdbMovieResultResponse>(cb){
    override fun getLayoutIdForPosition(position: Int): Int {
        return R.layout.item_movie
    }


//    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
//        super.onBindViewHolder(holder, position)
//        val moviePoster = holder.itemView.findViewById<ImageView>(R.id.imgMoviePoster)
//
//        moviePoster.load("https://image.tmdb.org/t/p/w500/wwemzKWzjKYJFfCeiB57q3r4Bcm.png"){
//            crossfade(true)
//            placeholder(R.drawable.poster_placeholder)
//            scale(Scale.FILL)
//        }
//    }
}