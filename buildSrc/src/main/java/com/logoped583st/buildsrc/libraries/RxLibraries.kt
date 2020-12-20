package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val rxJavaPackage = "io.reactivex.rxjava3:rxjava"
private const val rxJavaVersion = "3.0.8"

private const val rxAndroidPackage = "io.reactivex.rxjava3:rxandroid"
private const val rxAndroidVersion = "3.0.0"

internal enum class RxLibraries(override val library: Library) : LibraryImporter {

    RxJava(Library(rxJavaPackage, rxJavaVersion)),

    RxAndroid(Library(rxAndroidPackage, rxAndroidVersion));

    override val import: DependencyHandler.() -> Unit = {
        implementation(library)
    }
}

fun DependencyHandler.rx() {
    importFromArray(RxLibraries.values())
}
