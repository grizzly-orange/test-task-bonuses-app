package com.grizzlyorange.bonusesview.data.bonuses

import com.grizzlyorange.bonusesdata.api.data.bonuses.BonusesInfo

class BonusesMapper {
    companion object {
        fun fromDomainToView(bonusesInfo: BonusesInfo?): BonusesViewInfo? {
            return bonusesInfo?.let {
                BonusesViewInfo(
                    bonusesInfo.totalBonusesAmount,
                    bonusesInfo.burningBonusesAmount,
                    bonusesInfo.burningDateInMillis
                )
            }
        }
    }
}