package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val daggerPackage = "com.google.dagger:dagger"
private const val daggerCompilerPackage = "com.google.dagger:dagger-compiler"

private const val daggerVersion = "2.30.1"

private enum class DaggerLibraries(override val library: Library) : LibraryImporter {

    Dagger(Library(daggerPackage, daggerVersion)),

    DaggerCompiler(Library(daggerCompilerPackage, daggerVersion)) {
        override val import: DependencyHandler.() -> Unit = {
            kapt(library)
        }
    };

    override val import: DependencyHandler.() -> Unit = {
        implementation(library)
    }
}

fun DependencyHandler.dagger() {
    importFromArray(DaggerLibraries.values())
}
