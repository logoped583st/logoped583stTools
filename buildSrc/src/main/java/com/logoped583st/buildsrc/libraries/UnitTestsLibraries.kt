package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val junitPackage = "junit:junit"
private const val junitVersion = "4.13.1"

private const val mockitoPackage = "org.mockito:mockito-core"
private const val mockitoVersion = "1.10.19"

private const val androidXTestCorePackage = "androidx.test:core"
private const val androidXTestCoreVersion = "1.0.0"

internal enum class UnitTestsLibraries(override val library: Library) : LibraryImporter {

    Junit(Library(junitPackage, junitVersion)),

    Mockito(Library(mockitoPackage, mockitoVersion)),

    AndroidXTestCore(Library(androidXTestCorePackage, androidXTestCoreVersion));

    override val import: DependencyHandler.() -> Unit = {
        implementation(library)
    }
}

fun DependencyHandler.unitTests() {
    importFromArray(UnitTestsLibraries.values())
}