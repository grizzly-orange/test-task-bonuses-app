package com.grizzlyorange.bonusesview.data

import com.grizzlyorange.bonusesdata.api.data.BonusesInfo

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