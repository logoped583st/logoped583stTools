package com.logoped583st.buildsrc.libraries

object KotlinLibraries {

    private const val kotlinGroup = "org.jetbrains.kotlin"
    private const val kotlinStdModule = "kotlin-stdlib"
    private const val kotlinVersion = "1.4.21"

    val kotlinLibrary = Library(kotlinGroup, kotlinStdModule, kotlinVersion)
}
