import com.logoped583st.buildsrc.libraries.dagger
import com.logoped583st.buildsrc.libraries.ktx
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

    ktx()
    dagger()
}