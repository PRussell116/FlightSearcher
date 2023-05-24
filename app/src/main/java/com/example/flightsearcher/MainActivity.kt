package com.example.flightsearcher

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.flightsearcher.ui.Screens.FlightSearcherApp
import com.example.flightsearcher.ui.theme.FlightSearcherTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlightSearcherTheme {
                FlightSearcherApp()
            }
        }
    }
}

