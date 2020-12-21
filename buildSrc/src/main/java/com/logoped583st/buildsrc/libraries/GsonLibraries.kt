package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val gsonPackage = "com.google.code.gson:gson"
private const val gsonVersion = "2.8.6"

private val gsonLibrary= Library(gsonPackage, gsonVersion)

fun DependencyHandler.gson(){
    implementation(gsonLibrary)
}