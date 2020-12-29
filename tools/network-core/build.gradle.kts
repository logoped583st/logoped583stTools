import com.logoped583st.buildsrc.libraries.dagger
import com.logoped583st.buildsrc.libraries.gson
import com.logoped583st.buildsrc.libraries.kotlin
import com.logoped583st.buildsrc.libraries.network
import com.logoped583st.buildsrc.setupJava8
import com.logoped583st.buildsrc.setupSdkVersions

plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

android {
    setupSdkVersions()
    setupJava8()
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":dagger-component-connector"))

    kotlin()
    gson()
    network()
    dagger()
}