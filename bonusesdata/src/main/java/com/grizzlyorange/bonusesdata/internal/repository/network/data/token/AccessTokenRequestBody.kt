package com.grizzlyorange.bonusesdata.internal.repository.network.data.token

import com.grizzlyorange.bonusesdata.api.data.identity.ClientIdentityData

data class AccessTokenRequestBody(
    val accessToken: String = "",
    val idClient: String = "", // {ClientID}
    val latitude: Int = 0, // 0
    val longitude: Int = 0, // 0
    val paramName: String = "device", // device
    val paramValue: String = "", // {DeviceID}
    val sourceQuery: Int = 0 // 0
) {
    companion object {
        fun build(identityData: ClientIdentityData): AccessTokenRequestBody {
            return AccessTokenRequestBody(
                idClient = identityData.clientId,
                paramValue = identityData.deviceId
            )
        }
    }
}