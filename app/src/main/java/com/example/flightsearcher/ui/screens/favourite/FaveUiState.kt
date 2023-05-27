package com.example.flightsearcher.ui.screens.favourite

import com.example.flightsearcher.data.FaveEntity
import com.example.flightsearcher.data.FlightEntitiy

data class FaveUiState(
    val id: Int =0,
    val depart: String = "",
    val arrive: String ="",
    val departCode: String = "",
    val arriveCode: String = "",
    val flights: List<FlightEntitiy> = listOf()
)

fun FlightEntitiy.toFaveState(actionEnabled: Boolean = false): FaveUiState = FaveUiState(
    id = id,
    depart = name,
    departCode = iataCode,
)

fun FaveUiState.toFaveEntity(): FaveEntity = FaveEntity(
    id = id,
    departureCode = departCode,
    destinationCode = arriveCode
)