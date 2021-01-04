package com.logoped583st.buildsrc.libraries

object KotlinAndroidExtensions {

    private const val ktxAndroidGroup = "androidx.core"
    private const val ktxAndroidCoreModule = "core-ktx"
    private const val ktxAndroidCoreVersion = "1.3.2"

    val ktxCoreLibrary = Library(ktxAndroidGroup, ktxAndroidCoreModule, ktxAndroidCoreVersion)
}
