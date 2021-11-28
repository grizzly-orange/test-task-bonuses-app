package com.grizzlyorange.bonusesdata.repository.network.data

data class AccessTokenRequestBody(
    val accessToken: String = "",
    val idClient: String = "2c44d8c2-c89a-472e-aab3-9a8a29142315", // {ClientID}
    val latitude: Int = 0, // 0
    val longitude: Int = 0, // 0
    val paramName: String = "device", // device
    val paramValue: String = "7db72635-fd0a-46b9-813b-1627e3aa02ea", // {DeviceID}
    val sourceQuery: Int = 0 // 0
)