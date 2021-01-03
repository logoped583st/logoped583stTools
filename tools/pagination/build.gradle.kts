import com.logoped583st.buildsrc.libraries.*
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

    kotlin()
    ktx()
    paging()
    rx()
    implementation ("androidx.lifecycle:lifecycle-reactivestreams-ktx:2.2.0")

}