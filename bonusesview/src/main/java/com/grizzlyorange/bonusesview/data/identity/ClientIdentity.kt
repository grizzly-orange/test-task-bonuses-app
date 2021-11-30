package com.grizzlyorange.bonusesview.data.identity

class ClientIdentity private constructor(){
    var clientId: String = ""
    var deviceId: String = ""

    companion object {
        private var _instance: ClientIdentity? = null

        fun getInstance(): ClientIdentity {
            if (_instance == null) {
                _instance = ClientIdentity()
            }
            return _instance!!
        }
    }
}