import com.logoped583st.buildsrc.libraries.kotlin
import com.logoped583st.buildsrc.libraries.ktx
import com.logoped583st.buildsrc.libraries.paging
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
    paging()
    ktx()
}