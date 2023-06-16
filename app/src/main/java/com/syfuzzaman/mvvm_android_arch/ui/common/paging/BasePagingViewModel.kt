package com.syfuzzaman.mvvm_android_arch.ui.common.paging

import androidx.lifecycle.ViewModel
import androidx.paging.PagingData
import kotlinx.coroutines.flow.Flow

abstract class BasePagingViewModel<T : Any> : ViewModel() {
    protected abstract fun repo(): BaseListRepository<T>// by lazy { BaseListRepositoryImpl(apiService) }
    open var enableToolbar = true
    
    fun getListData(): Flow<PagingData<T>> {
        return repo().getList()
        //.cachedIn(viewModelScope)
    }
    
    open fun onItemClicked(item: T) {}
}