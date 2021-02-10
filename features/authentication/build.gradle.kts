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
    implementation(project(":tools:dagger-component-holder"))
    implementation(project(":tools:network-core"))

    implementation(AndroidLibraries.androidxAppCompatLibrary.notation)
    implementation(AndroidLibraries.androidxAppCompatResourcesLibrary.notation)
    implementation(AndroidLibraries.androidxFragmentLibrary.notation)
    implementation(AndroidLibraries.androidxFragmentKtxLibrary.notation)
    implementation(AndroidLibraries.bindingDelegateLibrary.notation)

    implementation(UiLibraries.materialLibrary.notation)
    implementation(UiLibraries.constraintLibrary.notation)

    implementation(KotlinAndroidExtensions.ktxCoreLibrary.notation)
    implementation(KotlinAndroidExtensions.ktxLifecycleLibrary.notation)

    implementation(CiceroneLibraries.ciceroneLibrary.notation)

    implementation(RxLibraries.rxLibrary.notation)

    implementation(DaggerLibraries.daggerLibrary.notation)
    kapt(DaggerLibraries.daggerCompiler.notation)

    implementation(NetworkLibraries.retrofit.notation)

}