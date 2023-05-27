package com.example.flightsearcher.data

import kotlinx.coroutines.flow.Flow

interface FlightRepo {
    fun getAllAirportsStream(): Flow<List<FlightEntitiy>>

    fun getSearchTerm(term:String): Flow<List<FlightEntitiy>>

    fun getWhereNotLike(id: Int): Flow<List<FlightEntitiy>>

    fun getFaveStream(id:Int): Flow<FaveEntity>

    fun getFlightStream(id:Int):Flow<FlightEntitiy?>

    suspend fun insertFave(faveEntity: FaveEntity)

    suspend fun deleteFave(faveEntity: FaveEntity)


}