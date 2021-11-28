package com.grizzlyorange.bonusesview.view

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.grizzlyorange.bonusesdata.api.BonusesRepository
import com.grizzlyorange.bonusesview.data.BonusesMapper
import com.grizzlyorange.bonusesview.data.BonusesViewInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BonusesViewModel @Inject constructor(
    private val bonusesRepository: BonusesRepository
) : ViewModel() {
    val bonuses: LiveData<BonusesViewInfo> = liveData {
        val bonusesInfo = bonusesRepository.getBonusesInfo()
        emit(BonusesMapper.fromDomainToView(bonusesInfo))
    }
}