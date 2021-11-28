package com.grizzlyorange.bonusesdata.repository

import com.grizzlyorange.bonusesdata.api.BonusesRepository
import com.grizzlyorange.bonusesdata.api.data.BonusesInfo
import com.grizzlyorange.bonusesdata.repository.network.BonusesWebApi
import com.grizzlyorange.bonusesdata.repository.network.data.AccessTokenRequestBody
import com.grizzlyorange.bonusesdata.repository.network.data.BonusesResponse
import java.lang.Exception

class BonusesRepositoryImpl(
    private val bonusesWebApi: BonusesWebApi
) : BonusesRepository {
    private val accessKey = "891cf53c-01fc-4d74-a14c-592668b7a03c"

    override suspend fun getBonusesInfo(): BonusesInfo {
        return try {
            val accessToken = loadAccessToken()
            val bonusesResponse = loadBonusesInfo(accessToken)
            convertBonusesResponse(bonusesResponse)
        } catch (e: Exception) {
            //TODO handle error
            BonusesInfo((1..100).random())
        }
    }

    private suspend fun loadAccessToken(): String {
        return bonusesWebApi
            .getToken(accessKey, AccessTokenRequestBody())
            .accessToken
    }

    private suspend fun loadBonusesInfo(accessToken: String): BonusesResponse {
        return bonusesWebApi
            .getBonusesInfo(accessKey, accessToken)
    }

    private fun convertBonusesResponse(bonusesResponse: BonusesResponse): BonusesInfo {
        return BonusesInfo(
            bonusesResponse.data.currentQuantity,
            bonusesResponse.data.forBurningQuantity,
            //TODO: convert datetime
            0
        )
    }
}