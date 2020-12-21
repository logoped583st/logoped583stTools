package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val rxBindingPackage = "com.jakewharton.rxbinding4:rxbinding"
private const val rxBindingCorePackage = "com.jakewharton.rxbinding4:rxbinding-core"
private const val rxBindingRecyclerPackage = "com.jakewharton.rxbinding4:rxbinding-recyclerview"
private const val rxBindingSwipeRefreshPackage =
    "com.jakewharton.rxbinding4:rxbinding-swiperefreshlayout"
private const val rxBindingViewPager2Package = "com.jakewharton.rxbinding4:rxbinding-viewpager2"
private const val rxBindingMaterialPackage = "com.jakewharton.rxbinding4:rxbinding-material"

private const val rxBindingVersion = "4.0.0"

private enum class RxBindingLibraries(override val library: Library) : LibraryImporter {

    RxBinding(Library(rxBindingPackage, rxBindingVersion)),

    RxBindingCore(Library(rxBindingCorePackage, rxBindingVersion)),

    RxBindingRecycler(Library(rxBindingRecyclerPackage, rxBindingVersion)),

    RxBindingSwipeRefresh(Library(rxBindingSwipeRefreshPackage, rxBindingVersion)),

    RxBindingViewPager2(Library(rxBindingViewPager2Package, rxBindingVersion)),

    RxBindingMaterial(Library(rxBindingMaterialPackage, rxBindingVersion));

    override val import: DependencyHandler.() -> Unit = {
        implementation(library)
    }
}

fun DependencyHandler.rxBinding() {
    importFromArray(RxBindingLibraries.values())
}
