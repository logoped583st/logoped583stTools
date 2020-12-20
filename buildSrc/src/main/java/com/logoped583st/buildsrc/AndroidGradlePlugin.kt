package com.logoped583st.buildsrc

import com.android.build.gradle.BaseExtension
import org.gradle.api.JavaVersion
import org.gradle.api.Plugin
import org.gradle.api.Project

private const val androidPlugin = "com.android.application"
private const val kotlinAndroidPlugin = "kotlin-android"

class AndroidGradlePlugin : Plugin<Project> {

    override fun apply(target: Project) {
        target.plugins.run {
            apply(androidPlugin)
            apply(kotlinAndroidPlugin)
        }
    }
}

private const val compile_sdk_version = 30
private const val build_tools_version = "30.0.3"

private const val application_id = "com.logoped583st.logopedTools"
private const val min_sdk = 21
private const val target_sdk = compile_sdk_version

private const val version_code = 1
private const val version_name = "1.0.0"

private const val test_instrumentation = "androidx.test.runner.AndroidJUnitRunner"


fun BaseExtension.setupConfig() {
    compileSdkVersion(compile_sdk_version)
    buildToolsVersion(build_tools_version)

    defaultConfig {
        applicationId = application_id
        minSdk = min_sdk
        targetSdk = target_sdk

        versionCode = version_code
        versionName = version_name

        testInstrumentationRunner = test_instrumentation
    }

    buildTypes {
        getByName("release") {
            minifyEnabled(true)
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }

    compileOptions {
        setSourceCompatibility(JavaVersion.VERSION_1_8)
        setTargetCompatibility(JavaVersion.VERSION_1_8)
    }
}
