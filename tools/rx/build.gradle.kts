import com.logoped583st.buildsrc.libraries.DaggerLibraries
import com.logoped583st.buildsrc.libraries.KotlinLibraries
import com.logoped583st.buildsrc.libraries.RxLibraries
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

    implementation(KotlinLibraries.kotlinLibrary.notation)
    implementation(DaggerLibraries.daggerLibrary.notation)
    kapt(DaggerLibraries.daggerCompiler.notation)
    implementation(RxLibraries.rxLibrary.notation)
    implementation(RxLibraries.rxAndroid.notation)
}