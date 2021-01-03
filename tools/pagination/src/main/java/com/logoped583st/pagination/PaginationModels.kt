package com.logoped583st.pagination

interface PaginationResponse<I : Any, K> {
    val data: List<I>
    val pagination: Pagination<K>
}

interface Pagination<K> {
    val next: K?
    val prev: K?
}

