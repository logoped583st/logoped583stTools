import com.logoped583st.buildsrc.libraries.KotlinAndroidExtensions
import com.logoped583st.buildsrc.libraries.KotlinLibraries
import com.logoped583st.buildsrc.libraries.PagingLibraries
import com.logoped583st.buildsrc.libraries.RxLibraries
import com.logoped583st.buildsrc.setupJava8
import com.logoped583st.buildsrc.setupSdkVersions

plugins {
    `android-library`
    `kotlin-android`
}

android {
    setupSdkVersions()
    setupJava8()
}

dependencies {

    implementation(KotlinLibraries.kotlinLibrary.notation)
    implementation(KotlinAndroidExtensions.ktxCoreLibrary.notation)

    implementation(PagingLibraries.pagingLibrary.notation)
    implementation(PagingLibraries.pagingRxLibrary.notation)

    implementation(RxLibraries.rxLibrary.notation)
    implementation(RxLibraries.rxAndroid.notation)

    implementation("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.2.0")

}