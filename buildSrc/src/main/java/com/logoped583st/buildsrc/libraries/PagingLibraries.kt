package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val pagingPackage = "androidx.paging:paging-runtime"
private const val pagingRxPackage = "androidx.paging:paging-rxjava3"
private const val pagingVersion = "3.0.0-alpha11"

internal enum class PagingLibraries(override val library: Library) : LibraryImporter {

    Paging(Library(pagingPackage, pagingVersion)),

    PagingRx(Library(pagingRxPackage, pagingVersion));

    override val import: DependencyHandler.() -> Unit = {
        implementation(library)
    }
}

fun DependencyHandler.paging(){
    importFromArray(PagingLibraries.values())
}