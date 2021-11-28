package com.grizzlyorange.bonusesdata.repository

import com.grizzlyorange.bonusesdata.api.BonusesRepository

class BonusesRepositoryImpl : BonusesRepository {
    override fun getBonuses(): Int {
        return (1..100).random()
    }
}