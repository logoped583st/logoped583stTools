import com.logoped583st.buildsrc.libraries.*
import com.logoped583st.buildsrc.setupConfig

plugins {
    android
    `kotlin-android`
    `kotlin-kapt`
}

android {
    setupConfig()

    defaultConfig {
        applicationId = com.logoped583st.buildsrc.application_id
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
}