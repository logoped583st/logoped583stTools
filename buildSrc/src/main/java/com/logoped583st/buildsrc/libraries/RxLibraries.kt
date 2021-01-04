package com.logoped583st.buildsrc.libraries


object RxLibraries {
    private const val rxGroup = "io.reactivex.rxjava3"
    private const val rxJavaModule = "rxjava"
    private const val rxJavaVersion = "3.0.8"

    private const val rxAndroidModule = "rxandroid"
    private const val rxAndroidVersion = "3.0.0"

    val rxLibrary = Library(rxGroup, rxJavaModule, rxJavaVersion)
    val rxAndroid = Library(rxGroup, rxAndroidModule, rxAndroidVersion)
}