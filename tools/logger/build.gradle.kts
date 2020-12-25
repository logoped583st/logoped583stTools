import com.logoped583st.buildsrc.libraries.dagger
import com.logoped583st.buildsrc.libraries.timber
import com.logoped583st.buildsrc.setupConfig

plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

android {
    setupConfig()
}

dependencies {
    implementation(project(":dagger-component-connector"))


    timber()
    dagger()
}