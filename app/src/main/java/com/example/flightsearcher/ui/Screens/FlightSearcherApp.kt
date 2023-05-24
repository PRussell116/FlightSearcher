package com.example.flightsearcher.ui.Screens

import android.util.Log
import android.widget.SearchView
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.example.flightsearcher.data.FlightEntitiy
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.toList

@Composable
fun FlightSearcherApp(viewModel: FlightSearchViewModel = viewModel(factory = FlightSearchViewModel.factory)){



    val flightUiState by viewModel.uiState.collectAsState()

    Column() {
        Row(){
            Icon(Icons.Filled.Search, contentDescription = "Search button")
            
            Spacer(modifier = Modifier.padding(horizontal = 10.dp))
            var textInput by remember { mutableStateOf(TextFieldValue("")) }
            TextField(

                value = textInput, onValueChange = {
                        newText -> textInput = newText
                        flightUiState.searchTerm = newText.text
                        if(flightUiState.searchTerm == "" || flightUiState.searchTerm == " "){
                            viewModel.updateFlights("")

                        }else{
                            viewModel.updateFlights(term = newText.text)
                        }
                    Log.d("LOG", flightUiState.searchTerm)
                },
                singleLine = true,
            )
      }
        Spacer(modifier = Modifier.padding(20.dp))

        AirportScreen(flights = flightUiState.flightList)

    }

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