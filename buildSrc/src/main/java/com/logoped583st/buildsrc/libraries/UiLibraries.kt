package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val materialUiPackage = "com.google.android.material:material"
private const val materialUiVersion = "1.2.1"

private const val constraintLayoutPackage = "androidx.constraintlayout:constraintlayout"
private const val constraintLayoutVersion = "2.0.4"

private const val viewPager2Package = "androidx.viewpager2:viewpager2"
private const val viewPager2Version = "1.0.0"

internal enum class UiLibraries(override val library: Library) : LibraryImporter {

    MaterialUi(Library(materialUiPackage, materialUiVersion)),

    ConstraintLayout(Library(constraintLayoutPackage, constraintLayoutVersion)),

    ViewPager2(Library(viewPager2Package, viewPager2Version));

    override val import: DependencyHandler.() -> Unit = {
        implementation(library)
    }
}

fun DependencyHandler.ui() {
    importFromArray(UiLibraries.values())
}
