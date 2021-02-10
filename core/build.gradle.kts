import com.logoped583st.buildsrc.libraries.*
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
    implementation(project(":tools:network-core"))

    implementation(KotlinLibraries.kotlinLibrary.notation)

    implementation(DaggerLibraries.daggerLibrary.notation)
    kapt(DaggerLibraries.daggerCompiler.notation)

    implementation(NetworkLibraries.retrofit.notation)
}