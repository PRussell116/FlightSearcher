package com.example.flightsearcher.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "airport")
data class FlightEntitiy (

    @PrimaryKey(autoGenerate = true) val id:Int,

    @ColumnInfo(name = "name") val name: String,

    @ColumnInfo(name = "iata_code") val iataCode: String,

    @ColumnInfo(name = "passengers") val passengers: Int
    )
