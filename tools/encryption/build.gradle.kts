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
}

dependencies {
    implementation(project(":dagger-component-connector"))
    implementation(GsonLibraries.gsonLibrary.notation)

    implementation(DaggerLibraries.daggerLibrary.notation)
    kapt(DaggerLibraries.daggerCompiler.notation)
}