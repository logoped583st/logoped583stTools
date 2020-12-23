package com.logoped583st.buildsrc.libraries

import org.gradle.api.artifacts.dsl.DependencyHandler
import org.gradle.kotlin.dsl.exclude

private const val retrofitGroup = "com.squareup.retrofit2"
private const val retrofitModule = "retrofit"
private const val retrofitGsonPackage = "com.squareup.retrofit2:converter-gson"
private const val retrofitRxJavaAdapterPackage = "com.squareup.retrofit2:adapter-rxjava3"
private const val okhttpGroup = "com.squareup.okhttp3"
private const val okhttpModule = "okhttp"
private const val okhttpLoggingModule = "logging-interceptor"

const val retrofitVersion = "2.9.0"
const val okhttpVersion = "4.7.2"

private enum class NetworkLibraries(override val library: Library) : LibraryImporter {

    Retrofit(Library("$retrofitGroup:$retrofitModule", retrofitVersion)) {
        override val import: DependencyHandler.() -> Unit = {
            api(library) {
                exclude(okhttpGroup, okhttpModule)
            }
        }
    },

    RetrofitGson(Library(retrofitGsonPackage, retrofitVersion)) {
        override val import: DependencyHandler.() -> Unit = {
            api(library) {
                exclude(okhttpGroup, okhttpModule)
                exclude(retrofitGroup, retrofitModule)
            }
        }
    },

    RetrofitRxJava(Library(retrofitRxJavaAdapterPackage, retrofitVersion)) {
        override val import: DependencyHandler.() -> Unit = {
            implementation(library) {
                exclude(retrofitGroup, retrofitModule)
            }
        }
    },

    OkHttp(Library("$okhttpGroup:$okhttpModule", okhttpVersion)){
        override val import: DependencyHandler.() -> Unit = {
            api(library)
        }
    },

    OkhttpLogging(Library("$okhttpGroup:$okhttpLoggingModule", okhttpVersion)){
        override val import: DependencyHandler.() -> Unit = {
            implementation(library){
                exclude(okhttpGroup, okhttpModule)
            }
        }
    };

    override val import: DependencyHandler.() -> Unit = {
        implementation(library)
    }

}

fun DependencyHandler.network() {
    importFromArray(NetworkLibraries.values())
}