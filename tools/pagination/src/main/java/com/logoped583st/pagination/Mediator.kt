package com.logoped583st.pagination

import androidx.paging.ExperimentalPagingApi
import androidx.paging.LoadType
import androidx.paging.PagingSource
import androidx.paging.PagingState
import androidx.paging.rxjava3.RxRemoteMediator
import io.reactivex.rxjava3.core.Completable
import io.reactivex.rxjava3.core.Single

@ExperimentalPagingApi
open class Mediator<I : Any, R : PaginationResponse<I, K>, K : Any>(
        val request: (PagingSource.LoadParams<K>) -> Single<R>,
        val cache: (PagingSource.LoadParams<K>) -> Single<R>,
        val clearCache: () -> Completable
) : RxRemoteMediator<I, R>() {

    final override fun loadSingle(loadType: LoadType, state: PagingState<I, R>): Single<MediatorResult> {
        TODO()
    }

}