import com.logoped583st.buildsrc.libraries.*
import com.logoped583st.buildsrc.setupConfig
import com.logoped583st.buildsrc.setupJava8
import com.logoped583st.buildsrc.setupSdkVersions

plugins {
    android
    `kotlin-android`
    `kotlin-kapt`
}

android {
    setupConfig()
    setupSdkVersions()
    setupJava8()
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":shared-resources"))
    implementation(project(":dagger-component-connector"))
    implementation(project(":tools:encryption"))
    implementation(project(":tools:logger"))
    implementation(project(":tools:android-tools"))

    ui()
    kotlin()
    ktx()
    dagger()
    rx()
    rxBinding()
    paging()
    unitTests()
    timber()
}