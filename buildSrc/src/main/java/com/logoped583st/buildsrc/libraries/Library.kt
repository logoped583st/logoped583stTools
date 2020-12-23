package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.ModuleDependency
import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.add

data class Library(val packageName: String, val version: String) {
    val notation = "$packageName:$version"
}

fun DependencyHandler.implementation(library: Library,
                                     exclude: ModuleDependency.() -> Unit = {}
): ModuleDependency =
        add("implementation", library.notation) {
            exclude()
        }


fun DependencyHandler.api(library: Library,
                          exclude: ModuleDependency.() -> Unit = {}
): ModuleDependency =
        add("api", library.notation) {
            exclude()
        }


fun DependencyHandler.kapt(
        library: Library,
        exclude: ModuleDependency.() -> Unit = {})
        : ModuleDependency =
        add("kapt", library.notation) {
            exclude()
        }


fun DependencyHandler.testImplementation(
        library: Library,
        exclude: ModuleDependency.() -> Unit = {}
): ModuleDependency =
        add("testImplementation", library.notation) {
            exclude()
        }


fun DependencyHandler.androidTestImplementation(
        library: Library,
        exclude: ModuleDependency.() -> Unit = {}
): ModuleDependency =
        add("androidTestImplementation", library.notation) {
            exclude()
        }

