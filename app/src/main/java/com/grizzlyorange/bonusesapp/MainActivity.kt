package com.grizzlyorange.bonusesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.grizzlyorange.bonusesview.api.SetupIdentity
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupIdentity()
    }

    private fun setupIdentity() {
        SetupIdentity.clientId = "2c44d8c2-c89a-472e-aab3-9a8a29142315"
        SetupIdentity.deviceId = "7db72635-fd0a-46b9-813b-1627e3aa02ea"
    }
}