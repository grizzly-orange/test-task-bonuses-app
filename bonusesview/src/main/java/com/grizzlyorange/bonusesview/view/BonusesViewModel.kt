package com.grizzlyorange.bonusesview.view

import androidx.lifecycle.*
import com.grizzlyorange.bonusesdata.api.repository.BonusesRepository
import com.grizzlyorange.bonusesdata.api.data.bonuses.BonusesInfo
import com.grizzlyorange.bonusesdata.api.data.identity.ClientIdentityData
import com.grizzlyorange.bonusesdata.api.data.Resource
import com.grizzlyorange.bonusesview.R
import com.grizzlyorange.bonusesview.data.bonuses.BonusesMapper
import com.grizzlyorange.bonusesview.data.bonuses.BonusesViewInfo
import com.grizzlyorange.bonusesview.data.events.ErrorEvent
import com.grizzlyorange.bonusesview.data.identity.ClientIdentity
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class BonusesViewModel @Inject constructor(
    private val bonusesRepository: BonusesRepository,
    private val clientIdentity: ClientIdentity
) : ViewModel() {

    private val _bonusesRequestResult: LiveData<Resource<BonusesInfo>> =
        bonusesRepository.getBonusesInfo(getIdentity()).asLiveData()

    val bonuses: LiveData<BonusesViewInfo?> = _bonusesRequestResult.switchMap { bonusesResult ->
        liveData {
            emit(BonusesMapper.fromDomainToView(bonusesResult.data))
        }
    }

    val isLoading: LiveData<Boolean> = _bonusesRequestResult.switchMap { bonusesRequestState ->
        liveData {
            emit(bonusesRequestState is Resource.Loading)
        }
    }

    val isSuccess: LiveData<Boolean> = _bonusesRequestResult.switchMap { bonusesRequestState ->
        liveData {
            emit(bonusesRequestState is Resource.Success)
        }
    }

    val isError: LiveData<ErrorEvent<Int>> = _bonusesRequestResult.switchMap { bonusesRequestState ->
        liveData {
            if (bonusesRequestState is Resource.Error) {
                emit(ErrorEvent<Int>(R.string.messageBonusesInfoResultError))
            }
        }
    }

    private fun getIdentity(): ClientIdentityData {
        return ClientIdentityData(clientIdentity.clientId, clientIdentity.deviceId)
    }
}