package com.grizzlyorange.bonusesview.view

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.grizzlyorange.bonusesview.R
import com.grizzlyorange.bonusesview.utils.DateTimeFormatter

@BindingAdapter("bonusesAmount")
fun setBonusesAmount(textView: TextView, bonusesAmount: Int?) {
    bonusesAmount?.let {
        textView.text = textView.context.resources
            .getQuantityString(R.plurals.bonusesAmount, bonusesAmount, bonusesAmount)
    }
}

@BindingAdapter("bonusesBurningDateInMillis")
fun setBonusesBurningDate(textView: TextView, dateInMillis: Long?) {
    dateInMillis?.let {
        textView.text = textView.context
            .getString(
                R.string.txtBonusesBurningDate,
                DateTimeFormatter.getDateTimeStringFromMillis(dateInMillis, "dd.MM")
            )
    }
}
