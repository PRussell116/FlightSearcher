package com.example.flightsearcher.ui.screens.desitnations

import com.example.flightsearcher.R
import com.example.flightsearcher.ui.navigation.NavigationDestination

object AirportFlightDestination: NavigationDestination {
    override val route =""
    override val titleRes = R.string.AirportFlightsTitle
    const val airportIdArg = "airportId"
    val routeWithArgs = "$route/{$airportIdArg}"

}