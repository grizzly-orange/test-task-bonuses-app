package com.grizzlyorange.bonusesdata.internal.repository.network.data.token

data class AccessTokenResponse(
    val accessToken: String, // string
    val result: Result
) {
    data class Result(
        val codeResult: Int, // 0
        val duration: Int, // 0
        val idLog: String, // 3fa85f64-5717-4562-b3fc-2c963f66afa6
        val message: String, // string
        val messageDev: String, // string
        val status: Int // 0
    )
}