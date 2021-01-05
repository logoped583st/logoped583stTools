import com.logoped583st.buildsrc.libraries.AndroidLibraries
import com.logoped583st.buildsrc.libraries.KotlinLibraries
import com.logoped583st.buildsrc.libraries.RxLibraries
import com.logoped583st.buildsrc.libraries.DaggerLibraries
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

    buildFeatures {
        viewBinding = true
    }
}

dependencies {

    implementation(KotlinLibraries.kotlinLibrary.notation)

    implementation(AndroidLibraries.androidxFragmentLibrary.notation)
    implementation(RxLibraries.rxLibrary.notation)

    implementation(DaggerLibraries.daggerLibrary.notation)
    kapt(DaggerLibraries.daggerCompiler.notation)
}