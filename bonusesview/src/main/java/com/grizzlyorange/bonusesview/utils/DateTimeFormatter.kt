package com.grizzlyorange.bonusesview.utils

import java.text.SimpleDateFormat
import java.util.*

class DateTimeFormatter {
    companion object {
        fun getDateTimeStringFromMillis(dateTimeInMillis: Long, pattern: String): String {
            val formatter = SimpleDateFormat(pattern, Locale.US)
            return formatter.format(Date(dateTimeInMillis))
        }
    }
}