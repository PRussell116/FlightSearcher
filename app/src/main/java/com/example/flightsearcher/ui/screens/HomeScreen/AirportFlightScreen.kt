package com.example.flightsearcher.ui.screens.HomeScreen

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearcher.data.FlightEntitiy

import com.example.flightsearcher.ui.screens.HomeScreen.FlightSearchViewModel

//@Composable
//fun AirportFlightScreen(
//    airport: FlightEntitiy,
//    flightViewModel: FlightSearchViewModel = viewModel(factory = AppV),
//    navigateBack:()->Unit,
//){
//
//    val uiState by flightViewModel.uiState.collectAsState()
//
//
//    Text(text = "Flights from ${airport.iataCode}")
//
//
//
//    LazyColumn(modifier = Modifier, contentPadding = PaddingValues(vertical = 2.dp)){
//        items(
//            items = uiState.flightList,
//            key = {flight ->
//                flight.id
//            }
//        ){flight ->
//            FavouriteCard(
//                depart = airport.name ,
//                departCode = airport.iataCode,
//                arrive = flight.name,
//                arriveCode = flight.iataCode,
//                checked = flightViewModel.isAFave(airport.iataCode,flight.iataCode),
//                viewModel = flightViewModel
//            )
//        }
//    }
//}


