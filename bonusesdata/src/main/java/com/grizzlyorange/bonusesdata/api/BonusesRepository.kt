package com.grizzlyorange.bonusesdata.api

import com.grizzlyorange.bonusesdata.api.data.BonusesInfo

interface BonusesRepository {
    suspend fun getBonusesInfo(): BonusesInfo
}