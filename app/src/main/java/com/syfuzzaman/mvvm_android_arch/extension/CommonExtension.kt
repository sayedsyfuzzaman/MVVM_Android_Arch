package com.syfuzzaman.mvvm_android_arch.extension

import android.net.Uri
import android.os.Bundle
import androidx.annotation.IdRes
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import androidx.navigation.fragment.findNavController

fun Fragment.navigateTo(@IdRes destinationId: Int) {
    if (findNavController().currentDestination?.id != destinationId) {
        findNavController().navigate(destinationId)
    }
}

fun NavController.navigateTo(@IdRes resId: Int, args: Bundle? = null, navOptions: NavOptions? = null) {
    this.navigate(resId, args, navOptions ?: androidx.navigation.navOptions {
        launchSingleTop = true
    })
}

fun NavController.navigateTo(deepLink: Uri, navOptions: NavOptions? = null) {
    this.navigate(deepLink, navOptions ?: androidx.navigation.navOptions {
        launchSingleTop = true
    })
}

fun NavController.navigatePopUpTo(
    @IdRes resId: Int,
    args: Bundle? = null,
    inclusive: Boolean? = true,
    @IdRes popUpTo: Int? = null,
    navOptions: NavOptions? = null
) {
    this.navigate(resId, args, navOptions ?: androidx.navigation.navOptions {
        launchSingleTop = true
        popUpTo(popUpTo ?: resId) {
            inclusive?.let {
                this.inclusive = inclusive
            }
        }
    })
}