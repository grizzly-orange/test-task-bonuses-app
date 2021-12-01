package com.grizzlyorange.bonusesdata.internal.repository.network

import com.grizzlyorange.bonusesdata.internal.repository.network.data.token.AccessTokenRequestBody
import com.grizzlyorange.bonusesdata.internal.repository.network.data.token.AccessTokenResponse
import com.grizzlyorange.bonusesdata.internal.repository.network.data.bonuses.BonusesResponse
import retrofit2.http.*

interface BonusesWebApi {
    @POST("api/v3/clients/accesstoken")
    suspend fun getToken(
        @Body body: AccessTokenRequestBody
    ): AccessTokenResponse

    @GET("/api/v3/ibonus/generalinfo/{AccessToken}")
    suspend fun getBonusesInfo(
        @Path("AccessToken") accessToken: String
    ): BonusesResponse
}