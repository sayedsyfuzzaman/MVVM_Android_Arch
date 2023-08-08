package com.syfuzzaman.mvvm_android_arch.data.storage

import android.content.Context
import android.content.SharedPreferences

const val PREF_NAME_MVVM_ARCH = "MVVM_ARCH"
class SessionPreference (private val pref: SharedPreferences, private val context: Context){
    var isLoggedInFromSubHistory: Boolean
        get() = pref.getBoolean(PREF_LOGGEDIN_FROM_SUB_HISTORY_STATUS, false)
        set(isActive) {
            pref.edit().putBoolean(PREF_LOGGEDIN_FROM_SUB_HISTORY_STATUS, isActive).apply()
        }


    companion object {
        private const val PREF_LOGGEDIN_FROM_SUB_HISTORY_STATUS = "pref_loggedin_from_subhistory_status"

        private var instance: SessionPreference? = null

        fun init(mContext: Context) {
            if (instance == null) {
                instance = SessionPreference(
                    mContext.getSharedPreferences(
                        PREF_NAME_MVVM_ARCH,
                        Context.MODE_PRIVATE
                    ), mContext
                )
            }
        }

        fun getInstance(): SessionPreference {
            if (instance == null) {
                throw InstantiationException("Instance is null...call init() first")
            }
            return instance as SessionPreference
        }

    }
}