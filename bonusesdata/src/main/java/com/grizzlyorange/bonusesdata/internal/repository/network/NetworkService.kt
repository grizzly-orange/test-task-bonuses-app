package com.grizzlyorange.bonusesdata.internal.repository.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkService {
    companion object {
        private val baseUrl = "https://mp1.iprobonus.com/"
        private val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl(baseUrl)
            .build()
        val api: BonusesWebApi = retrofit.create(BonusesWebApi::class.java)
    }
}