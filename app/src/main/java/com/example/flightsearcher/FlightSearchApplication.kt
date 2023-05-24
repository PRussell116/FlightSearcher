package com.example.flightsearcher

import android.app.Application
import com.example.flightsearcher.data.FlightDatabase

class FlightSearchApplication :Application(){
    val database: FlightDatabase by lazy { FlightDatabase.getDB(this) }
}