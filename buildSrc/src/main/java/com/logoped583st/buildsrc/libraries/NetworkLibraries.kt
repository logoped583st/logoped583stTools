package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler

private const val retrofitPackage = "com.squareup.retrofit2:retrofit"
private const val retrofitGsonPackage = "com.squareup.retrofit2:converter-gson"
private const val retrofitRxJavaAdapterPackage = "com.squareup.retrofit2:adapter-rxjava3"
private const val okhttpPackage = "com.squareup.okhttp3:okhttp"
private const val okhttpLoggingInterceptorPackage = "com.squareup.okhttp3:logging-interceptor"

const val retrofitVersion = "2.9.0"
const val okhttpVersion = "4.7.2"

private enum class NetworkLibraries(override val library: Library) : LibraryImporter {

    Retrofit(Library(retrofitPackage, retrofitVersion)),

    RetrofitGson(Library(retrofitGsonPackage, retrofitVersion)),

    RetrofitRxJava(Library(retrofitRxJavaAdapterPackage, retrofitVersion)),

    OkHttp(Library(okhttpPackage, okhttpVersion)),

    OkhttpLogging(Library(okhttpLoggingInterceptorPackage, okhttpVersion));

    override val import: DependencyHandler.() -> Unit = {
        implementation(library)
    }

}

fun DependencyHandler.network() {
    importFromArray(NetworkLibraries.values())
}