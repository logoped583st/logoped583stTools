package com.logoped583st.buildsrc.libraries

object RxBindingLibraries {
    private const val rxBindingGroup = "com.jakewharton.rxbinding4"
    private const val rxBindingVersion = "4.0.0"

    const val rxBindingModule = "rxBinding"
    const val rxBindingCoreModule = "rxbinding-core"
    const val rxBindingSwipeRefreshModule = "rxbinding-swiperefreshlayout"
    const val rxBindingRecyclerModule = "rxbinding-recyclerview"
    const val rxBindingMaterialModule = "rxbinding-material"

    val rxBindingLibrary = Library(rxBindingGroup, rxBindingModule, rxBindingVersion)
    val rxBindingCoreLibrary = Library(rxBindingGroup, rxBindingCoreModule, rxBindingVersion)
    val rxBindingSwipeRefreshLibrary = Library(rxBindingGroup, rxBindingSwipeRefreshModule, rxBindingVersion)
    val rxBindingRecyclerLibrary = Library(rxBindingGroup, rxBindingRecyclerModule, rxBindingMaterialModule)
}



