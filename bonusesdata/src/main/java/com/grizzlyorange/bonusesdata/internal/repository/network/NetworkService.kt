package com.grizzlyorange.bonusesdata.internal.repository.network

import okhttp3.Interceptor
import okhttp3.OkHttpClient
import okhttp3.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {

    companion object {

        private val baseUrl = "https://mp1.iprobonus.com/"
        private val accessKey = "891cf53c-01fc-4d74-a14c-592668b7a03c"

        private val accessKeyHeaderInterceptor : Interceptor = Interceptor { chain ->
            val originalRequest = chain.request()
            val requestBuilder = originalRequest.newBuilder()
                .header("AccessKey", accessKey)
            val request = requestBuilder.build()
            chain.proceed(request)
        }

        private val httpClient = OkHttpClient().newBuilder()
            .addInterceptor(accessKeyHeaderInterceptor)
            .build()

        private val retrofit = Retrofit.Builder()
            .client(httpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()

        val api: BonusesWebApi = retrofit
            .create(BonusesWebApi::class.java)
    }
}