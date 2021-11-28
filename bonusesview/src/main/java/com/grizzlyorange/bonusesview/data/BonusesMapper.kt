package com.grizzlyorange.bonusesview.data

import com.grizzlyorange.bonusesdata.api.data.BonusesInfo

class BonusesMapper {
    companion object {
        fun fromDomainToView(bonusesInfo: BonusesInfo): BonusesViewInfo {
            return BonusesViewInfo(
                bonusesInfo.totalBonusesAmount.toString(),
                bonusesInfo.burningBonusesAmount.toString(),
                bonusesInfo.burningDateInMillis
            )
        }
    }
}