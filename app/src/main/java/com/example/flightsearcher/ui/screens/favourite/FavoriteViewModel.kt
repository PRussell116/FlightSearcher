package com.example.flightsearcher.ui.screens.favourite

import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.flightsearcher.data.FlightRepo
import com.example.flightsearcher.ui.screens.HomeScreen.FlightSearchViewModel
import com.example.flightsearcher.ui.screens.desitnations.AirportFlightDestination
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.stateIn

class FavoriteViewModel(
    savedStateHandle: SavedStateHandle,
    private val flightRepo: FlightRepo,
    ): ViewModel() {
        private val airportId: Int = checkNotNull(savedStateHandle[AirportFlightDestination.airportIdArg])
    val uiState: StateFlow<FaveUiState> = flightRepo.getWhereNotLike(airportId)
        .filterNotNull()
        .map {

        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(FavoriteViewModel.TIMEOUT_MILLIS),
            initialValue = FlightSearchViewModel.AirportUiState(listOf(), "")
        ) as StateFlow<FaveUiState>



    companion object{
        private const val TIMEOUT_MILLIS = 5_00L
    }


}