package com.example.flightsearcher.ui.Screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearcher.FlightSearchApplication
import com.example.flightsearcher.data.AirportDAO
import com.example.flightsearcher.data.FlightEntitiy
import kotlinx.coroutines.flow.Flow

class FlightSearchViewModel(private val flightDao: AirportDAO):ViewModel(){

    fun getAllFlights(): Flow<List<FlightEntitiy>> = flightDao.getAllAirports()

    fun getSearchTerm(term: String): Flow<List<FlightEntitiy>> = flightDao.getSearchTerm(term)

    companion object{
        val factory:ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FlightSearchApplication)
                FlightSearchViewModel(application.database.airportDAO())
            }
        }
    }

}