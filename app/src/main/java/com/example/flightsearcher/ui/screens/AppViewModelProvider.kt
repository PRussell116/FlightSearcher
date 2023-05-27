package com.example.flightsearcher.ui.screens

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.flightsearcher.FlightSearchApplication
import com.example.flightsearcher.ui.screens.favourite.FavoriteViewModel
import com.example.flightsearcher.ui.screens.HomeScreen.FlightSearchViewModel

object AppViewModelProvider {
    val Factory = viewModelFactory {
        initializer {
            FlightSearchViewModel(this.createSavedStateHandle(),flightSearchAppliction().container.flightRepo)
        }
        initializer {
            FavoriteViewModel(
                this.createSavedStateHandle(),
                flightSearchAppliction().container.flightRepo)
        }
    }
}

fun CreationExtras.flightSearchAppliction():FlightSearchApplication = (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY]as FlightSearchApplication)