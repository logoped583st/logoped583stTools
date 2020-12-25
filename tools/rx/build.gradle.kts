import com.logoped583st.buildsrc.libraries.dagger
import com.logoped583st.buildsrc.libraries.kotlin
import com.logoped583st.buildsrc.libraries.rx

plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

dependencies {
    implementation(project(":dagger-component-connector"))

    kotlin()
    dagger()
    rx()
}