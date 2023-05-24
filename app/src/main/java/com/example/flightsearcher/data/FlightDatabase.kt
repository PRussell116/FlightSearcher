package com.example.flightsearcher.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [FlightEntitiy::class,FaveEntity::class], version = 1, exportSchema = false)
abstract class FlightDatabase: RoomDatabase() {
    abstract fun airportDAO(): AirportDAO

    companion object{
        @Volatile
        private var Instance:FlightDatabase? = null

        fun getDB(context: Context):FlightDatabase{
            return Instance ?: synchronized(this){
                Room.databaseBuilder(context,FlightDatabase::class.java,"FlightDB")
                    .createFromAsset("database/flight_search.db")
                   .fallbackToDestructiveMigration()
                    .build()
                    .also { Instance = it }
            }
        }
    }
}