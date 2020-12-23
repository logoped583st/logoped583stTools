package com.logoped583st.network_core.client

import com.google.gson.GsonBuilder
import com.google.gson.JsonDeserializer
import io.reactivex.rxjava3.core.Scheduler
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.adapter.rxjava3.RxJava3CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Inject

private const val connectNetworkTimeout = 5L
private const val readNetworkTimeOut = 10L
private const val writeTimeOut = 15L

interface NetworkClient {
    fun retrofitClient(baseUrl: String): Retrofit.Builder
    fun okhttpClient(): OkHttpClient.Builder
}

internal class NetworkClientImpl @Inject constructor(
        private val requestScheduler: Scheduler,
        dateConverter: JsonDeserializer<Date>
) : NetworkClient {

    private val gson = GsonBuilder()
            .registerTypeAdapter(Date::class.java, dateConverter)
            .create()


    override fun okhttpClient() = OkHttpClient.Builder()
            .connectTimeout(connectNetworkTimeout, TimeUnit.SECONDS)
            .readTimeout(readNetworkTimeOut, TimeUnit.SECONDS)
            .writeTimeout(writeTimeOut, TimeUnit.SECONDS)

    override fun retrofitClient(baseUrl: String): Retrofit.Builder = Retrofit.Builder()
            .baseUrl(baseUrl)
            .addCallAdapterFactory(RxJava3CallAdapterFactory.createWithScheduler(requestScheduler))
            .addConverterFactory(GsonConverterFactory.create(gson))

}
