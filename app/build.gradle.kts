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