package com.grizzlyorange.bonusesview

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.grizzlyorange.bonusesdata.api.BonusesRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BonusesViewModel @Inject constructor(
    private val bonusesRepository: BonusesRepository
) : ViewModel() {
    val bonuses: LiveData<Int> = MutableLiveData<Int>(
        bonusesRepository.getBonuses()
    )
}