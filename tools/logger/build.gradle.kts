import com.logoped583st.buildsrc.libraries.dagger
import com.logoped583st.buildsrc.libraries.timber

plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

dependencies {
    implementation(project(":dagger-component-connector"))


    timber()
    dagger()
}