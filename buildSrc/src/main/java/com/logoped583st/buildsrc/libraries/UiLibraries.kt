package com.logoped583st.buildsrc.libraries

object UiLibraries {

    private const val materialGroup = "com.google.android.material"
    private const val materialModule = "material"
    private const val materialVersion = "1.2.1"

    private const val constraintLayoutGroup = "androidx.constraintlayout"
    private const val constraintLayoutModule = "constraintlayout"
    private const val constraintLayoutVersion = "2.0.4"

    private const val viewPager2Group = "androidx.viewpager2"
    private const val viewPager2Module = "viewPager2"
    private const val viewPager2Version = "1.0.0"

    private const val recyclerGroup = "androidx.recyclerview"
    private const val recyclerModule = "recyclerview"
    private const val recyclerVersion = "1.1.0"

    val materialLibrary = Library(materialGroup, materialModule, materialVersion)
    val constraintLibrary = Library(constraintLayoutGroup, constraintLayoutModule, constraintLayoutVersion)
    val viewPager2Library = Library(viewPager2Group, viewPager2Module, viewPager2Version)
    val recyclerLibrary = Library(recyclerGroup, recyclerModule, recyclerVersion)

}