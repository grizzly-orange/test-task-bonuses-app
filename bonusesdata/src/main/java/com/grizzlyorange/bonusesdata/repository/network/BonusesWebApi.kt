package com.grizzlyorange.bonusesdata.repository.network

import com.grizzlyorange.bonusesdata.repository.network.data.AccessTokenRequestBody
import com.grizzlyorange.bonusesdata.repository.network.data.AccessTokenResponse
import com.grizzlyorange.bonusesdata.repository.network.data.BonusesResponse
import retrofit2.http.*

interface BonusesWebApi {
    @POST("api/v3/clients/accesstoken")
    suspend fun getToken(
        @Header("AccessKey") accessKey: String,
        @Body body: AccessTokenRequestBody
    ): AccessTokenResponse

    @GET("/api/v3/ibonus/generalinfo/{AccessToken}")
    suspend fun getBonusesInfo(
        @Header("AccessKey") accessKey: String,
        @Path("AccessToken") accessToken: String
    ): BonusesResponse
}