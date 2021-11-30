package com.grizzlyorange.bonusesview.view

import android.util.Log
import androidx.lifecycle.*
import com.grizzlyorange.bonusesdata.api.BonusesRepository
import com.grizzlyorange.bonusesdata.api.data.BonusesInfo
import com.grizzlyorange.bonusesdata.api.data.Resource
import com.grizzlyorange.bonusesview.data.BonusesMapper
import com.grizzlyorange.bonusesview.data.BonusesViewInfo
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BonusesViewModel @Inject constructor(
    private val bonusesRepository: BonusesRepository
) : ViewModel() {
    private val _bonusesRequestResult: LiveData<Resource<BonusesInfo>> = bonusesRepository.getBonusesInfo().asLiveData()

    val bonuses: LiveData<BonusesViewInfo?> = _bonusesRequestResult.switchMap { bonusesResult ->
        liveData {
            emit(BonusesMapper.fromDomainToView(bonusesResult.data))
        }
    }

    val isLoading: LiveData<Boolean> = _bonusesRequestResult.switchMap { bonusesRequestState ->
        liveData {
            emit(bonusesRequestState is Resource.Loading )
        }
    }
}