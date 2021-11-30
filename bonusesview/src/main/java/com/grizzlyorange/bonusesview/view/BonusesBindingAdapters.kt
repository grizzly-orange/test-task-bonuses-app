package com.grizzlyorange.bonusesview.view

import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.grizzlyorange.bonusesview.R

@BindingAdapter("bonusesAmount")
fun setBonusesAmount(textView: TextView, bonusesAmount: Int) {
    textView.text = textView.context.resources
        .getQuantityString(R.plurals.bonusesAmount, bonusesAmount, bonusesAmount)
}
