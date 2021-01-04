package com.logoped583st.buildsrc.libraries

object NetworkLibraries {
    private const val retrofitGroup = "com.squareup.retrofit2"
    private const val retrofitModule = "retrofit"
    private const val retrofitGsonModule = "converter-gson"
    private const val retrofitRxConverterModule = "adapter-rxjava3"

    private const val okhttpGroup = "com.squareup.okhttp3"
    private const val okhttpModule = "okhttp"
    private const val okhttpLoggingModule = "logging-interceptor"

    private const val retrofitVersion = "2.9.0"
    private const val okhttpVersion = "4.7.2"

    val retrofit = Library(retrofitGroup, retrofitModule, retrofitVersion)
    val retrofitGson = Library(retrofitGroup, retrofitGsonModule, retrofitVersion)
    val retrofitRxConverter = Library(retrofitGroup, retrofitRxConverterModule, retrofitVersion)
    val okhttp = Library(okhttpGroup, okhttpModule, okhttpVersion)
    val okhttpLogging = Library(okhttpGroup, okhttpLoggingModule, okhttpVersion)
}



