package com.grizzlyorange.bonusesdata.repository

import com.grizzlyorange.bonusesdata.api.BonusesRepository
import com.grizzlyorange.bonusesdata.api.data.BonusesInfo

class BonusesRepositoryImpl : BonusesRepository {
    override suspend fun getBonusesInfo(): BonusesInfo {
        return BonusesInfo((1..100).random())
    }
}