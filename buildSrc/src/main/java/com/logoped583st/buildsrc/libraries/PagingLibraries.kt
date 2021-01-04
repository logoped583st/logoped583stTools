package com.logoped583st.buildsrc.libraries


object PagingLibraries {
    private const val pagigngGroup = "androidx.paging"
    private const val pagingRuntimeModule = "paging-runtime"
    private const val pagingRxModule = "paging-rxjava3"
    private const val pagingVersion = "3.0.0-alpha11"

    val pagingLibrary = Library(pagigngGroup, pagingRuntimeModule, pagingVersion)
    val pagingRxLibrary = Library(pagigngGroup, pagingRxModule, pagingVersion)
}
