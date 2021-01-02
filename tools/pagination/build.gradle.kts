import com.logoped583st.buildsrc.libraries.dagger
import com.logoped583st.buildsrc.libraries.kotlin
import com.logoped583st.buildsrc.libraries.paging
import com.logoped583st.buildsrc.libraries.rx
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
}

dependencies {

    implementation(project(":dagger-component-connector"))

    kotlin()
    paging()
    rx()
    dagger()
}