package com.grizzlyorange.bonusesview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BonusesViewModel @Inject constructor(

) : ViewModel() {
    val bonuses: LiveData<Int> = MutableLiveData<Int>((1..100).random())
}