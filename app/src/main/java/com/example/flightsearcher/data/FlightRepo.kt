package com.example.flightsearcher.data

import kotlinx.coroutines.flow.Flow

interface FlightRepo {
    fun getAllAirportsStream(): Flow<List<FlightEntitiy>>

    fun getSearchTerm(term:String): Flow<List<FlightEntitiy>>

    fun getFlightStream():Flow<FlightEntitiy?>

    suspend fun insertFave(faveEntity: FaveEntity)

    suspend fun deleteFave(faveEntity: FaveEntity)
}