package com.logoped583st.buildsrc.libraries

object DaggerLibraries {
    private const val daggerGroup = "com.google.dagger"
    private const val daggerModule = "dagger"
    private const val daggerCompilerModule = "dagger-compiler"

    private const val daggerVersion = "2.30.1"

    val daggerLibrary = Library(daggerGroup, daggerModule, daggerVersion)
    val daggerCompiler = Library(daggerGroup, daggerCompilerModule, daggerVersion)
}

