package com.example.flightsearcher.data

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
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

    @Query("SELECT * FROM Airport WHERE iata_code LIKE :codeToSearch")
    fun getByIATA(codeToSearch: String):Flow<List<FlightEntitiy>>


    @Query("SELECT * from favorite ORDER BY departure_code ASC")
    fun getAllFaves():Flow<List<FaveEntity>>




    @Query("DELETE FROM favorite WHERE id = :idToDelete")
    fun removeFave(idToDelete: Int){

    }

    @Query("DELETE FROM favorite WHERE destination_code = :arrivalCode AND departure_code = :departCode")
    fun removeFave(arrivalCode: String,departCode: String){

    }

//    @Query("INSERT INTO favorite VALUES (:arrivalCode,:departCode)")
//    fun addFave(arrivalCode:String,departCode:String)

    @Query("SELECT * FROM favorite WHERE departure_code = :depCode AND destination_code = :arrivalCode")
    fun isAFave(depCode:String,arrivalCode: String): Flow<FaveEntity>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insert(faveEntity: FaveEntity)

    @Delete
    suspend fun delete(faveEntity: FaveEntity)

    @Query("SELECT * from airport WHERE NOT id = :airportId")
    fun getWherenotLikeName(airportId : Int): Flow<List<FlightEntitiy>>


}