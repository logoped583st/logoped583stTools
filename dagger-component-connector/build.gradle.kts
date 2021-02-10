import com.logoped583st.buildsrc.setupJava8
import com.logoped583st.buildsrc.setupSdkVersions
import com.logoped583st.buildsrc.libraries.*

plugins {
    `android-library`
    `kotlin-android`
    `kotlin-kapt`
}

android {
    setupSdkVersions()
    setupJava8()
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(KotlinLibraries.kotlinLibrary.notation)
    implementation(CiceroneLibraries.ciceroneLibrary.notation)
    implementation(RxLibraries.rxLibrary.notation)
}