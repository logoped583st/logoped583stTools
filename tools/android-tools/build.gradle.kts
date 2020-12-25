import com.logoped583st.buildsrc.libraries.ktx
import com.logoped583st.buildsrc.setupConfig

plugins {
    `android-library`
    `kotlin-android`
}

android {
    setupConfig()
}

dependencies {
    implementation(project(":dagger-component-connector"))

    ktx()
}