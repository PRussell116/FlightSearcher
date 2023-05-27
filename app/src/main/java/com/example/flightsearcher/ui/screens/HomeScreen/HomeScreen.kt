package com.example.flightsearcher.ui.screens.HomeScreen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.combinedClickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.flightsearcher.data.FlightEntitiy
import com.example.flightsearcher.ui.screens.AppViewModelProvider

@Composable
fun HomeScreen(
    navigateToAirport: () ->Unit,

    viewModel: FlightSearchViewModel = viewModel(factory = AppViewModelProvider.Factory)){

    val flightUiState by viewModel.uiState.collectAsState()

    Column(modifier = Modifier
        .fillMaxWidth()) {
        Row(modifier = Modifier
            .background(MaterialTheme.colorScheme.secondary)
            .align(CenterHorizontally)
            .height(60.dp)
            .fillMaxWidth()
        )
        {
            Icon(
                imageVector = Icons.Filled.Search,
                contentDescription = "Search button",
                modifier = Modifier
                    .align(CenterVertically)
                    .fillMaxHeight()
                    .weight(1f)
                ,
                tint = MaterialTheme.colorScheme.onSurface
            )

            var textInput by remember { mutableStateOf(TextFieldValue("")) }
            TextField(


                value = textInput,
                textStyle = MaterialTheme.typography.bodySmall ,
                onValueChange = {
                        newText -> textInput = newText
                        flightUiState.searchTerm = newText.text
                        if(flightUiState.searchTerm == "" || flightUiState.searchTerm == " "){
                            viewModel.updateFlights("")

                        }else{
                            viewModel.updateFlights(term = newText.text)
                        }
                },
                shape = RoundedCornerShape(20.dp),


                singleLine = true,
                modifier = Modifier
                    .background(MaterialTheme.colorScheme.secondary)
                    .fillMaxHeight()
                    .weight(4f)
                    .padding(5.dp)


            )

      }

        AirportScreen(flights = flightUiState.flightList, modifier = Modifier,navigateToAirport)



    }

}

@Composable
fun AirportScreen(flights: List<FlightEntitiy>,modifier: Modifier = Modifier,navigateToAirport: () -> Unit){

    LazyColumn(modifier = modifier, contentPadding = PaddingValues(vertical = 2.dp)){
        items(
            items = flights,
            key = {flight ->
                flight.id
            }
        ){flight ->
            FlightCard(code = flight.iataCode, airportName = flight.name, navigateToAirport = navigateToAirport)
        }
    }

}

@Composable
fun FlightCard(code : String, airportName: String,navigateToAirport: () -> Unit){
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 10.dp),

        modifier = Modifier
            .padding(top = 5.dp)
            .height(50.dp)
            .fillMaxWidth()
            .clickable(
                onClick = navigateToAirport
            )


    ) {
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .padding(15.dp)
                .fillMaxSize()
        ){

            Text(text = code , fontWeight = FontWeight.Bold, modifier = Modifier.padding(horizontal = 10.dp))

            Text(text = airportName, fontStyle = FontStyle.Normal , fontWeight = FontWeight.Thin, overflow = TextOverflow.Ellipsis)

        }
        
    }
}

//TODO add star functionality

//TODO add speech input?