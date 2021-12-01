package com.grizzlyorange.bonusesdata.internal.repository

import com.grizzlyorange.bonusesdata.api.repository.BonusesRepository
import com.grizzlyorange.bonusesdata.api.data.bonuses.BonusesInfo
import com.grizzlyorange.bonusesdata.api.data.identity.ClientIdentityData
import com.grizzlyorange.bonusesdata.api.data.Resource
import com.grizzlyorange.bonusesdata.internal.repository.network.BonusesWebApi
import com.grizzlyorange.bonusesdata.internal.repository.network.data.token.AccessTokenRequestBody
import com.grizzlyorange.bonusesdata.internal.repository.network.data.bonuses.BonusesResponse
import com.grizzlyorange.bonusesdata.internal.repository.network.data.bonuses.BonusesResponseConvertor
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import java.lang.Exception

class BonusesRepositoryImpl(
    private val bonusesWebApi: BonusesWebApi
) : BonusesRepository {

    override fun getBonusesInfo(clientIdentity: ClientIdentityData): Flow<Resource<BonusesInfo>> {
        return flow {
            try {
                emit(Resource.Loading<BonusesInfo>())
                val accessToken = loadAccessToken(clientIdentity)
                val bonusesResponse = loadBonusesInfo(accessToken)
                val bonusesInfo = convertBonusesResponse(bonusesResponse)
                emit(Resource.Success<BonusesInfo>(bonusesInfo))
            } catch (e: Exception) {
                emit(Resource.Error<BonusesInfo>("Error on receive or parse bonuses data"))
            }
        }
    }

    private suspend fun loadAccessToken(identityData: ClientIdentityData): String {
        return bonusesWebApi
            .getToken(AccessTokenRequestBody.build(identityData))
            .accessToken
    }

    private suspend fun loadBonusesInfo(accessToken: String): BonusesResponse {
        return bonusesWebApi
            .getBonusesInfo(accessToken)
    }

    private fun convertBonusesResponse(bonusesResponse: BonusesResponse): BonusesInfo {
        return BonusesResponseConvertor.convert(bonusesResponse)
    }
}