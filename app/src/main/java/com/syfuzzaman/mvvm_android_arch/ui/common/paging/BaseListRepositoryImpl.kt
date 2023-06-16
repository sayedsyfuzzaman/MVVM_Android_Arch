package com.syfuzzaman.mvvm_android_arch.ui.common.paging

import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.PagingSource
import kotlinx.coroutines.flow.Flow

class BaseListRepositoryImpl<T: Any> constructor(
    private val pagingFactory: ()-> PagingSource<Int, T>,
    private val remoteMediator: BaseRemoteMediator<T>? = null
): BaseListRepository<T> {
    override fun getList(): Flow<PagingData<T>> {
        return Pager(
            config = PagingConfig(
                PAGE_SIZE,
                enablePlaceholders = true,
                initialLoadSize = PAGE_SIZE,
                prefetchDistance = if(PAGE_SIZE > 20) 4 else 2,
//                maxSize = 2 * PAGE_SIZE
            ),
//            remoteMediator = remoteMediator,
            pagingSourceFactory = pagingFactory
        ).flow
    }
    
    companion object {
        const val PAGE_SIZE = 10
    }
}