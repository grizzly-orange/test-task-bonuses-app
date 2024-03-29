package com.grizzlyorange.bonusesdata.internal.repository.network.data.bonuses

import com.grizzlyorange.bonusesdata.api.data.bonuses.BonusesInfo
import java.text.SimpleDateFormat
import java.util.*

class BonusesResponseConvertor {
    companion object {
        fun convert(bonusesResponse: BonusesResponse): BonusesInfo {
            return BonusesInfo(
                bonusesResponse.data.currentQuantity,
                bonusesResponse.data.forBurningQuantity,
                convertDate(bonusesResponse.data.dateBurning)
            )
        }

        private fun convertDate(dateStr: String): Long {
            val format = SimpleDateFormat("yyyy-MM-dd'T'hh:mm:ss", Locale.US)
            val date = format.parse(dateStr)
            return date?.time ?: 0
        }
    }
}