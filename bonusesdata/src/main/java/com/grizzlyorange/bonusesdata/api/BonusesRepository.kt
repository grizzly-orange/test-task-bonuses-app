package com.grizzlyorange.bonusesdata.api

import com.grizzlyorange.bonusesdata.api.data.BonusesInfo
import com.grizzlyorange.bonusesdata.api.data.Resource

interface BonusesRepository {
    suspend fun getBonusesInfo(): Resource<BonusesInfo>
}