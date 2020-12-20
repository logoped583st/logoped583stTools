package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.add
import org.gradle.kotlin.dsl.exclude

data class Library(val packageName: String, val version: String) {
    val notation = "$packageName:$version"
}

data class Exclude(val groupName: String, val moduleName: String)

fun DependencyHandler.implementation(library: Library, exclude: Exclude? = null) {
    add("implementation", library.notation) {
        exclude?.apply { exclude(group, groupName) }
    }
}

fun DependencyHandler.kapt(library: Library, exclude: Exclude? = null) {
    add("kapt", library.notation) {
        exclude?.apply { exclude(group, groupName) }
    }
}

fun DependencyHandler.testImplementation(library: Library, exclude: Exclude? = null) {
    add("testImplementation", library.notation) {
        exclude?.apply { exclude(group, groupName) }
    }
}

fun DependencyHandler.androidTestImplementation(library: Library, exclude: Exclude? = null) {
    add("androidTestImplementation", library.notation) {
        exclude?.apply { exclude(group, groupName) }
    }
}
