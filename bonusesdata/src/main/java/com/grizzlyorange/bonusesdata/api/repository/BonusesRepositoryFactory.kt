package com.grizzlyorange.bonusesdata.api.repository

import com.grizzlyorange.bonusesdata.internal.repository.BonusesRepositoryImpl
import com.grizzlyorange.bonusesdata.internal.repository.network.NetworkService

class BonusesRepositoryFactory {
    companion object {
        private var bonusesRep: BonusesRepository? = null

        fun getBonusesRepository(): BonusesRepository {
            if (bonusesRep == null) {
                bonusesRep = BonusesRepositoryImpl(NetworkService.api)
            }
            return bonusesRep!!
        }
    }
}