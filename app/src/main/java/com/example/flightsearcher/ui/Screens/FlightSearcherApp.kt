package com.example.flightsearcher.ui.Screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.flightsearcher.data.FlightEntitiy

@Composable
fun FlightSearcherApp(viewModel: FlightSearchViewModel = viewModel(factory = FlightSearchViewModel.factory)){

    val navController = rememberNavController()
    val allAirports by viewModel.getAllFlights().collectAsState(emptyList())

    AirportScreen(flights = allAirports)
}
@Composable
fun AirportScreen(flights: List<FlightEntitiy>,modifier: Modifier = Modifier){
    LazyColumn(modifier = modifier, contentPadding = PaddingValues(vertical = 8.dp)){
        items(
            items = flights,
            key = {flight ->
                flight.id
            }
        ){flight ->
            flightCard(code = flight.iataCode, airportName = flight.name)

        }
    }

}

@Composable
fun flightCard(code : String,airportName: String){
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),
        modifier = Modifier
            .padding(top = 5.dp)
            .height(50.dp)
            .fillMaxWidth()
    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
        ){

            Text(text = code , fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 10.dp))



            Text(text = airportName, fontStyle = FontStyle.Normal , fontWeight = FontWeight.Thin)

        }
        
    }
}
@Preview
@Composable
fun flightCardPreview(){
    flightCard(code = "VIE", airportName = "Vienna International Airport")
}
//TODO add search functionality

//TODO add star fuctionaloty

//TODO add speech input?