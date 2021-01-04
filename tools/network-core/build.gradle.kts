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
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {

    implementation(project(":dagger-component-connector"))

    implementation(KotlinLibraries.kotlinLibrary.notation)
    implementation(GsonLibraries.gsonLibrary.notation)

    implementation(NetworkLibraries.retrofit.notation)
    implementation(NetworkLibraries.retrofitGson.notation)
    implementation(NetworkLibraries.retrofitRxConverter.notation)
    implementation(NetworkLibraries.okhttp.notation)
    implementation(NetworkLibraries.okhttpLogging.notation)

    implementation(LoggingLibraries.timberLibrary.notation)
    implementation(DaggerLibraries.daggerLibrary.notation)
}