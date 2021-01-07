package com.logoped583st.buildsrc.libraries

object KotlinAndroidExtensions {

    private const val ktxAndroidGroup = "androidx.core"
    private const val ktxAndroidCoreModule = "core-ktx"
    private const val ktxAndroidCoreVersion = "1.3.2"

    private const val ktxLifecycleGroup = "androidx.lifecycle"
    private const val ktxLifecycleRuntimeModule = "lifecycle-runtime-ktx"
    private const val ktxLifecycleLiveDataModule = "lifecycle-livedata"
    private const val ktxLifecycleViewModelModule = "lifecycle-viewmodel-ktx"
    private const val ktxLifecycleVersion = "2.2.0"


    val ktxCoreLibrary = Library(ktxAndroidGroup, ktxAndroidCoreModule, ktxAndroidCoreVersion)

    val ktxLifecycleLibrary =
            Library(ktxLifecycleGroup, ktxLifecycleLiveDataModule, ktxLifecycleVersion)

    val ktxLifecycleRuntimeLibrary =
            Library(ktxLifecycleGroup, ktxLifecycleRuntimeModule, ktxLifecycleVersion)



    val ktxLifecycleViewModelLibrary = Library(
            ktxLifecycleGroup, ktxLifecycleViewModelModule, ktxLifecycleVersion
    )
}
