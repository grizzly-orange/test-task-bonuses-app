package com.grizzlyorange.bonusesdata.repository

import android.util.Log
import com.grizzlyorange.bonusesdata.api.BonusesRepository
import com.grizzlyorange.bonusesdata.api.data.BonusesInfo
import com.grizzlyorange.bonusesdata.api.data.Resource
import com.grizzlyorange.bonusesdata.repository.network.BonusesWebApi
import com.grizzlyorange.bonusesdata.repository.network.data.AccessTokenRequestBody
import com.grizzlyorange.bonusesdata.repository.network.data.BonusesResponse
import com.grizzlyorange.bonusesdata.repository.network.data.BonusesResponseConvertor
import java.lang.Exception
import java.text.SimpleDateFormat
import java.util.*

class BonusesRepositoryImpl(
    private val bonusesWebApi: BonusesWebApi
) : BonusesRepository {
    private val accessKey = "891cf53c-01fc-4d74-a14c-592668b7a03c"

    override suspend fun getBonusesInfo(): Resource<BonusesInfo> {
        return try {
            val accessToken = loadAccessToken()
            val bonusesResponse = loadBonusesInfo(accessToken)
            Resource.Success<BonusesInfo>(convertBonusesResponse(bonusesResponse))
        } catch (e: Exception) {
            Resource.Error<BonusesInfo>("Error on receive or parse bonuses data")
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
        return BonusesResponseConvertor.convert(bonusesResponse)
    }
}