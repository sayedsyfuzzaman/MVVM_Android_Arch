package com.syfuzzaman.mvvm_android_arch.util

import android.widget.ImageView
import androidx.databinding.BindingAdapter
import coil.load
import coil.size.Scale
import com.syfuzzaman.mvvm_android_arch.R
import javax.inject.Singleton

@Singleton
class BindingUtil {
    companion object{
        @JvmStatic
        @BindingAdapter(value = ["loadImageFromUrl", "maintainRatio"], requireAll = false)
        fun bindImageFromUrl(view: ImageView, imageUrl: String?, maintainRatio: Boolean = true) {
            view.load("https://image.tmdb.org/t/p/original$imageUrl"){
                crossfade(true)
                placeholder(R.drawable.poster_placeholder)
                scale(Scale.FIT)
            }
        }
    }

}