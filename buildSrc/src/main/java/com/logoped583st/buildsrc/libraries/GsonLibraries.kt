package com.logoped583st.buildsrc.libraries

object GsonLibraries {
    private const val gsonGroup = "com.google.code.gson"
    private const val gsonModule = "gson"
    private const val gsonVersion = "2.8.6"

    val gsonLibrary = Library(gsonGroup, gsonModule, gsonVersion)
}
