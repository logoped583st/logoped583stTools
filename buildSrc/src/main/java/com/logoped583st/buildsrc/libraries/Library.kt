package com.logoped583st.buildsrc.libraries

data class Library(val group: String, val module: String, val version: String) {
    val notation: String = "$group:$module:$version"
}
