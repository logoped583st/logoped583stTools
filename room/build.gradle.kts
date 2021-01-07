import com.logoped583st.buildsrc.libraries.KotlinAndroidExtensions
import com.logoped583st.buildsrc.libraries.KotlinLibraries
import com.logoped583st.buildsrc.libraries.RoomLibraries
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

    implementation(KotlinLibraries.kotlinLibrary.notation)
    implementation(KotlinAndroidExtensions.ktxCoreLibrary.notation)

    implementation(RoomLibraries.roomLibrary.notation)
    implementation(RoomLibraries.roomRxJavaLibrary.notation)
    kapt(RoomLibraries.roomCompilerLibrary.notation)

}