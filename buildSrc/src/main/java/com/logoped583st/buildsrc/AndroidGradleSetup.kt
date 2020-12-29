package com.logoped583st.buildsrc

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion

private const val compile_sdk_version = 30
private const val build_tools_version = "30.0.3"

const val application_id = "com.logoped583st.logopedTools"
private const val min_sdk = 21
private const val target_sdk = compile_sdk_version

private const val version_code = 1
private const val version_name = "1.0.0"

private const val test_instrumentation = "androidx.test.runner.AndroidJUnitRunner"


fun BaseExtension.setupConfig() {
    defaultConfig {
        versionCode = version_code
        versionName = version_name
        applicationId = application_id

        testInstrumentationRunner = test_instrumentation
    }

//    buildTypes {
//        getByName("release") {
//            minifyEnabled(true)
//            proguardFiles(
//                    getDefaultProguardFile("proguard-android-optimize.txt"),
//                    "proguard-rules.pro"
//            )
//        }
//    }


}

fun BaseExtension.setupJava8() {
    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}

fun BaseExtension.setupSdkVersions() {
    compileSdkVersion(compile_sdk_version)
    buildToolsVersion(build_tools_version)

    defaultConfig {
        minSdk = min_sdk
        targetSdk = target_sdk
    }

}
