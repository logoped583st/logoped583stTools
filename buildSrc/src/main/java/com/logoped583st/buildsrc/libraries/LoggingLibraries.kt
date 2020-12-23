package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

const val timberPackage = "com.jakewharton.timber:timber"
const val timberVersion = "4.7.1"

private val timberLibrary = Library(timberPackage, timberVersion)

fun DependencyHandler.timber() {
    implementation(timberLibrary)
}
