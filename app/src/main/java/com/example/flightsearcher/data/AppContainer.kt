package com.example.flightsearcher.data

import android.content.Context

interface AppContainer {
    val flightRepo: FlightRepo
}

class AppDataContainer(private val context:Context) :AppContainer{
    override val flightRepo: FlightRepo by lazy {
        OfflineFlightRepo(FlightDatabase.getDB(context).airportDAO())
    }

}