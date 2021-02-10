import com.logoped583st.buildsrc.libraries.DaggerLibraries
import com.logoped583st.buildsrc.libraries.KotlinAndroidExtensions
import com.logoped583st.buildsrc.setupJava8
import com.logoped583st.buildsrc.setupSdkVersions
import com.logoped583st.buildsrc.libraries.CiceroneLibraries
import com.logoped583st.buildsrc.libraries.AndroidLibraries

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

    implementation(AndroidLibraries.androidxAppCompatLibrary.notation)
    implementation(AndroidLibraries.androidxAppCompatResourcesLibrary.notation)
    implementation(AndroidLibraries.androidxActivityLibrary.notation)
    implementation(AndroidLibraries.androidxActivityKtxLibrary.notation)

    implementation(KotlinAndroidExtensions.ktxCoreLibrary.notation)
    implementation(KotlinAndroidExtensions.ktxLifecycleLibrary.notation)
    implementation(CiceroneLibraries.ciceroneLibrary.notation)

    implementation(DaggerLibraries.daggerLibrary.notation)
    kapt(DaggerLibraries.daggerCompiler.notation)
}