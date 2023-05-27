package com.example.flightsearcher

import android.app.Application
import com.example.flightsearcher.data.AppContainer
import com.example.flightsearcher.data.AppDataContainer
import com.example.flightsearcher.data.FlightDatabase

class FlightSearchApplication :Application(){
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = AppDataContainer(this)
    }
}