package com.grizzlyorange.bonusesdata.api.data.bonuses

/**
 * Domain level data structure, it describes bonuses state.
 * Clients of 'bonusesdata' lib receive this data as result of request.
 */
data class BonusesInfo(
    val totalBonusesAmount: Int = 0,
    val burningBonusesAmount: Int = 0,
    val burningDateInMillis: Long = 0
)