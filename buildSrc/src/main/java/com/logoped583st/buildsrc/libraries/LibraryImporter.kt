package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

interface LibraryImporter {
    val library: Library

    val import: DependencyHandler.() -> Unit
}

fun DependencyHandler.importFromArray(array: Array<out LibraryImporter>) {
    array.forEach {
        it.import(this)
    }
}
