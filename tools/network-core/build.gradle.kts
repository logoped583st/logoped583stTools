import com.logoped583st.buildsrc.libraries.dagger
import com.logoped583st.buildsrc.libraries.gson
import com.logoped583st.buildsrc.libraries.kotlin
import com.logoped583st.buildsrc.libraries.network

plugins {
    kotlin
    `kotlin-kapt`
}


dependencies {

    implementation(project(":dagger-component-connector"))

    kotlin()
    gson()
    network()
    dagger()
}