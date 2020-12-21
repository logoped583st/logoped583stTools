package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val ciceronePackage = "com.github.terrakok:cicerone"
private const val ciceroneVersion = "6.6"

private val ciceroneLibrary = Library(ciceronePackage, ciceroneVersion)

fun DependencyHandler.cicerone() {
    implementation(ciceroneLibrary)
}