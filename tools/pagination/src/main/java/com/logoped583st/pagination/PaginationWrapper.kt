package com.logoped583st.pagination

import androidx.paging.ExperimentalPagingApi
import androidx.paging.Pager
import androidx.paging.PagingConfig
import androidx.paging.PagingData
import androidx.paging.rxjava3.RxPagingSource
import androidx.paging.rxjava3.cachedIn
import androidx.paging.rxjava3.observable
import io.reactivex.rxjava3.core.Observable
import kotlinx.coroutines.CoroutineScope


interface PaginationWrapper<R : PaginationResponse<*, *>> {
    val data: Observable<PagingData<R>>
}

@ExperimentalPagingApi
class PaginationWrapperImpl<I : Any, R : PaginationResponse<I, K>, K : Any>(
        config: PagingConfig,
        dataSourceProvider: () -> RxPagingSource<I, R>,
        mediator: Mediator<I, R, K>?,
        viewModelCoroutineScope: CoroutineScope
) : PaginationWrapper<R> {


    private val pager = Pager(
            config,
            remoteMediator = mediator
    ) {
        dataSourceProvider()
    }

    override val data = pager.observable.cachedIn(viewModelCoroutineScope)

}
