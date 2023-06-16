package com.syfuzzaman.mvvm_android_arch.ui.common.paging

import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

interface BaseListRepository<T: Any> {
    fun getList(): Flow<PagingData<T>>
}