package com.grizzlyorange.bonusesdata.api

import com.grizzlyorange.bonusesdata.repository.BonusesRepositoryImpl
import com.grizzlyorange.bonusesdata.repository.network.NetworkService

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