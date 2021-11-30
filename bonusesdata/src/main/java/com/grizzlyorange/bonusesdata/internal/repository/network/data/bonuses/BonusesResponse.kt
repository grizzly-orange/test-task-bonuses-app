package com.grizzlyorange.bonusesdata.internal.repository.network.data.bonuses

data class BonusesResponse(
    val data: Data,
    val resultOperation: ResultOperation
) {
    data class Data(
        val currentQuantity: Int, // 0
        val dateBurning: String, // 2021-11-27T17:51:11.623Z
        val forBurningQuantity: Int, // 0
        val typeBonusName: String // string
    )

    data class ResultOperation(
        val codeResult: Int, // 0
        val duration: Int, // 0
        val idLog: String, // 3fa85f64-5717-4562-b3fc-2c963f66afa6
        val message: String, // string
        val messageDev: String, // string
        val status: Int // 0
    )
}