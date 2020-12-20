package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val ktxAndroidCorePackage = "androidx.core:core-ktx"
private const val ktxAndroidCoreVersion = "1.3.2"

internal enum class KotlinExtensions(override val library: Library) : LibraryImporter {

    KtxCore(Library(ktxAndroidCorePackage, ktxAndroidCoreVersion));

    override val import: DependencyHandler.() -> Unit = {
        implementation(library)
    }
}

fun DependencyHandler.ktx() {
    importFromArray(KotlinExtensions.values())
}