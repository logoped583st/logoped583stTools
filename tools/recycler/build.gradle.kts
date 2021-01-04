import com.logoped583st.buildsrc.libraries.KotlinAndroidExtensions
import com.logoped583st.buildsrc.libraries.KotlinLibraries
import com.logoped583st.buildsrc.libraries.PagingLibraries
import com.logoped583st.buildsrc.setupJava8
import com.logoped583st.buildsrc.setupSdkVersions
import com.logoped583st.buildsrc.libraries.UiLibraries

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

    implementation(PagingLibraries.pagingLibrary.notation)
    implementation(PagingLibraries.pagingRxLibrary.notation)

    implementation(KotlinAndroidExtensions.ktxCoreLibrary.notation)
    implementation(UiLibraries.recyclerLibrary.notation)
}