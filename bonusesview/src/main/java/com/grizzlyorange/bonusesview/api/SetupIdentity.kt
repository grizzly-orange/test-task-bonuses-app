package com.grizzlyorange.bonusesview.api

import com.grizzlyorange.bonusesview.data.identity.ClientIdentity

class SetupIdentity {
    companion object {
        var clientId: String
            get() = ClientIdentity.getInstance().clientId
            set(value) {
                ClientIdentity.getInstance().clientId = value
            }

        var deviceId: String
            get() = ClientIdentity.getInstance().deviceId
            set(value) {
                ClientIdentity.getInstance().deviceId = value
            }
    }
}