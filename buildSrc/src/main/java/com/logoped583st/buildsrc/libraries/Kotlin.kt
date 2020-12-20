package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler


private const val kotlinVersion = "1.4.21"
private const val kotlinStdLibPackage = "org.jetbrains.kotlin:kotlin-stdlib"

private val kotlinStdLibrary = Library(kotlinStdLibPackage, kotlinVersion)

fun DependencyHandler.kotlin() {
    implementation(kotlinStdLibrary)
}
