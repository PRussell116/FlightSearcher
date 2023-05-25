package com.example.flightsearcher.data

import androidx.room.Dao
import androidx.room.Query
import kotlinx.coroutines.flow.Flow

@Dao
interface AirportDAO{
    @Query("SELECT * FROM Airport ORDER BY iata_code ASC")
    fun getAllAirports(): Flow<List<FlightEntitiy>>

    @Query("SELECT * FROM Airport WHERE name " +
            "LIKE :searchTerm " +
            "OR iata_code LIKE  :searchTerm " +
            "ORDER BY passengers DESC")
    fun getSearchTerm(searchTerm: String):Flow<List<FlightEntitiy>>


    // fav
//
//    @Query("SELECT * FROM favorite")
//    fun getAllFaves(): Flow<List<FlightEntitiy>>
}