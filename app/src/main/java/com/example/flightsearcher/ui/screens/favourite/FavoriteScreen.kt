package com.example.flightsearcher.ui.screens.favourite

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearcher.data.FlightEntitiy
import com.example.flightsearcher.ui.screens.AppViewModelProvider


@Composable
fun FavoriteScreen(
    navigateBack:() -> Unit,
    viewModel: FavoriteViewModel = viewModel(factory = AppViewModelProvider.Factory)
){
    val uiState = viewModel.uiState.collectAsState()
    val coroutineScope = rememberCoroutineScope()
    Scaffold(topBar = {
        Text("FAVE SCREEN")

    },) {it
        FaveScreenBody(
            faveUiState = uiState.value,
            faveList = uiState.value.flights

        )

    }
}
@Composable
fun FaveScreenBody(faveUiState: FaveUiState,faveList:List<FlightEntitiy>,modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier, verticalArrangement = Arrangement.spacedBy(8.dp)){
        items(items = faveList,key = {it.id}){
            flight ->
            FavouriteCard(departCode = flight.iataCode, depart = flight.name, arrive = faveUiState.arrive, arriveCode = faveUiState.arriveCode, checked = false)
            Divider()
        }
    }

}