package com.grizzlyorange.bonusesdata.api.data.identity

/**
 * Data for auth request.
 * Clients of 'bonusesdata' lib setup this data to receive results.
 */
class ClientIdentityData(
    val clientId: String,
    val deviceId: String
)