package com.example.flightsearcher.ui.Screens

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearcher.FlightSearchApplication
import com.example.flightsearcher.data.AirportDAO
import com.example.flightsearcher.data.FlightEntitiy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn
import java.lang.Thread.State

class FlightSearchViewModel(private val flightDao: AirportDAO):ViewModel(){

    var uiState: StateFlow<AirportUiState> = flightDao.getAllAirports().map { AirportUiState(it,"") }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = AirportUiState(listOf(),"")
        )

    fun getAllFlights(): Flow<List<FlightEntitiy>> = flightDao.getAllAirports()

    fun getSearchTerm(term: String): Flow<List<FlightEntitiy>> = flightDao.getSearchTerm(term)

    fun updateFlights(term: String){
        if(term == ("") || term == " "){
            uiState =flightDao.getAllAirports().map { AirportUiState(it,"") }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = AirportUiState(listOf(),"")
            )
        }
        uiState = flightDao.getSearchTerm("%${term}%").map{
            AirportUiState(it,"")
        }.stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = AirportUiState(listOf(),"")
        )
    }



    companion object{
        private const val TIMEOUT_MILLIS = 5_000L
        val factory:ViewModelProvider.Factory = viewModelFactory {
            initializer {
                val application = (this[APPLICATION_KEY] as FlightSearchApplication)
                FlightSearchViewModel(application.database.airportDAO())
            }
        }
    }

    data class AirportUiState(var flightList: List<FlightEntitiy> = listOf(), var searchTerm: String)

}