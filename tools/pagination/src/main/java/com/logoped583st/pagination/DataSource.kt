package com.logoped583st.pagination

import androidx.paging.rxjava3.RxPagingSource
import io.reactivex.rxjava3.core.Single

open class DataSource<I : Any, R : PaginationResponse<I, K>, K : Any>(
        private val request: (LoadParams<K>) -> Single<R>
) : RxPagingSource<K, I>() {

    final override fun loadSingle(params: LoadParams<K>): Single<LoadResult<K, I>> {
        return request(params)
                .map { toLoadResult(it) }
                .onErrorReturn { LoadResult.Error(it) }
    }

    private fun toLoadResult(data: PaginationResponse<I, K>): LoadResult<K, I> {
        return LoadResult.Page(
                data = data.data,
                prevKey = data.pagination.prev,
                nextKey = data.pagination.next
        )
    }
}