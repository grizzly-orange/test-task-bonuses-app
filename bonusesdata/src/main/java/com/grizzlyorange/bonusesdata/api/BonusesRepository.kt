package com.grizzlyorange.bonusesdata.api

import com.grizzlyorange.bonusesdata.api.data.BonusesInfo
import com.grizzlyorange.bonusesdata.api.data.Resource
import kotlinx.coroutines.flow.Flow

interface BonusesRepository {
    fun getBonusesInfo(): Flow<Resource<BonusesInfo>>
}