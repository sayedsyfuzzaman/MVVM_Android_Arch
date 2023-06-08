package com.syfuzzaman.mvvm_android_arch.data.network.exception

class JobCanceledError(
    code: Int,
    msg: String,
) : Error(code, msg)