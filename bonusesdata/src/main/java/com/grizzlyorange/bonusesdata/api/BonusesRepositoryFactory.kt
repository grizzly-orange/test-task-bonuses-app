package com.grizzlyorange.bonusesdata.api

import com.grizzlyorange.bonusesdata.repository.BonusesRepositoryImpl

class BonusesRepositoryFactory {
    companion object {
        private var bonusesRep: BonusesRepository? = null

        fun getBonusesRepository(): BonusesRepository {
            if (bonusesRep == null) {
                bonusesRep = BonusesRepositoryImpl()
            }
            return bonusesRep!!
        }
    }
}