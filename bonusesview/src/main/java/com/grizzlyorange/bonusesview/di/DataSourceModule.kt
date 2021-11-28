package com.grizzlyorange.bonusesview.di

import com.grizzlyorange.bonusesdata.api.BonusesRepository
import com.grizzlyorange.bonusesdata.api.BonusesRepositoryFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@InstallIn(SingletonComponent::class)
@Module
class DataSourceModule {

    @Provides
    fun getBonusesRepository(): BonusesRepository {
        return BonusesRepositoryFactory.getBonusesRepository()
    }
}