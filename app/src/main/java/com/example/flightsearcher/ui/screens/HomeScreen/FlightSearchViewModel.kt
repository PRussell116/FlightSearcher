package com.example.flightsearcher.ui.screens.HomeScreen

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProvider.AndroidViewModelFactory.Companion.APPLICATION_KEY
import androidx.lifecycle.viewModelScope
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearcher.FlightSearchApplication
import com.example.flightsearcher.data.FaveEntity
import com.example.flightsearcher.data.FlightEntitiy
import com.example.flightsearcher.data.FlightRepo
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onEmpty
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.runBlocking

class FlightSearchViewModel(savedStateHandle: SavedStateHandle,private val flightRepo: FlightRepo):ViewModel(){

    var uiState: StateFlow<AirportUiState> = flightRepo.getAllAirportsStream().map { AirportUiState(it,"") }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
            initialValue = AirportUiState(listOf(),"")
        )

    fun updateFlights(term: String){
        if(term == ("") || term == " "){
            uiState =flightRepo.getAllAirportsStream().map { AirportUiState(it,"") }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = AirportUiState(listOf(),"")
            )
        }else{
            uiState = flightRepo.getSearchTerm("%${term}%").map{
                AirportUiState(it,"")
            }.stateIn(
                scope = viewModelScope,
                started = SharingStarted.WhileSubscribed(TIMEOUT_MILLIS),
                initialValue = AirportUiState(listOf(),"")
            )
        }
    }
//    fun isAFave(depCode:String, arrCode:String):Boolean = runBlocking{
//        val res :Flow<FaveEntity>  = flightRepo.isAFave(depCode,arrCode)
//
//        res.onEmpty { false }
//        true
//
//    }
//    fun faveClicked(arrivalCode: String, departCode:String,checked: Boolean){
//        if(checked){
//            flightRepo.addFave(arrivalCode,departCode)
//        }else{
//            flightRepo.removeFave(arrivalCode,departCode)
//        }
//
//    }
//    fun getAllFaves(){
//        flightRepo.getAllFaves()
//    }



    companion object{
        private const val TIMEOUT_MILLIS = 5_000L

    }

    data class AirportUiState(var flightList: List<FlightEntitiy> = listOf(), var searchTerm: String)

}