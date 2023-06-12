package com.syfuzzaman.mvvm_android_arch.extension

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.SystemClock
import android.view.View
import android.widget.Toast
import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager

fun Context.showToast(message: String?, length: Int = Toast.LENGTH_SHORT) {
    if(!message.isNullOrBlank()) {
        Toast.makeText(this, message, length).show()
    }
}

inline fun <reified T : Any> FragmentActivity.launchActivity(
    requestCode: Int = -1,
    options: Bundle? = null,
    noinline init: Intent.() -> Unit = {}
) {
    val intent = newIntent<T>(this)
    intent.init()
    when (requestCode) {
        -1 -> startActivity(intent, options)
        else -> startActivityForResult(intent, requestCode, options)
    }
}

inline fun <reified T : Any> newIntent(context: Context): Intent =
    Intent(context, T::class.java)

fun View.setVisibility(isVisible: Boolean){
    this.visibility = if(isVisible) View.VISIBLE else View.GONE
}

fun MotionLayout.onTransitionCompletedListener(onCompleted:(transitionId: Int) -> Unit){
    this.addTransitionListener(object : MotionLayout.TransitionListener{
        override fun onTransitionStarted(motion: MotionLayout?, startId: Int, endId: Int) { }
        override fun onTransitionChange(motion: MotionLayout?, startId: Int, endId: Int, progress: Float) { }
        override fun onTransitionTrigger(motion: MotionLayout?, startId: Int, endId: Boolean, progress: Float) { }
        override fun onTransitionCompleted(motion: MotionLayout?, transitionId: Int) {
            onCompleted(transitionId)
        }
    })
}


fun View.safeClick(action: View.OnClickListener, debounceTime: Long = 1000L) {
    this.setOnClickListener(object : View.OnClickListener {
        private var lastClickTime: Long = 0

        override fun onClick(v: View) {
            if (SystemClock.elapsedRealtime() - lastClickTime < debounceTime) return else action.onClick(v)
            lastClickTime = SystemClock.elapsedRealtime()
        }
    })
}

val FragmentManager.currentNavigationFragment: Fragment?
    get() = primaryNavigationFragment?.childFragmentManager?.fragments?.firstOrNull()
