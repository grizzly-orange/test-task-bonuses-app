package com.grizzlyorange.bonusesdata.api.repository

import com.grizzlyorange.bonusesdata.api.data.bonuses.BonusesInfo
import com.grizzlyorange.bonusesdata.api.data.identity.ClientIdentityData
import com.grizzlyorange.bonusesdata.api.data.Resource
import kotlinx.coroutines.flow.Flow

interface BonusesRepository {
    fun getBonusesInfo(clientIdentity: ClientIdentityData): Flow<Resource<BonusesInfo>>
}