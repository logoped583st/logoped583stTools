import com.logoped583st.buildsrc.libraries.DaggerLibraries
import com.logoped583st.buildsrc.libraries.LoggingLibraries
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


    implementation(LoggingLibraries.timberLibrary.notation)
    implementation(DaggerLibraries.daggerLibrary.notation)
    kapt(DaggerLibraries.daggerCompiler.notation)
}