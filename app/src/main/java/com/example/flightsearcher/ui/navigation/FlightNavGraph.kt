package com.example.flightsearcher.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.flightsearcher.ui.screens.favourite.FavoriteScreen
import com.example.flightsearcher.ui.screens.HomeScreen.HomeScreen
import com.example.flightsearcher.ui.screens.desitnations.AirportFlightDestination
import com.example.flightsearcher.ui.screens.desitnations.HomeDestination

@Composable
fun AirportNavHost(navController: NavHostController, modifier: Modifier = Modifier){
    NavHost(
        navController = navController,
        startDestination = HomeDestination.route,
        modifier = modifier
    ){
        composable(route = HomeDestination.route){
            HomeScreen(
                navigateToAirport = { navController.navigate("${AirportFlightDestination.route}/${it}") }
            )
        }
        composable(route = AirportFlightDestination.route){
            FavoriteScreen(navigateBack = {navController.popBackStack() })
        }

        composable(route = AirportFlightDestination.routeWithArgs){
            FavoriteScreen(navigateBack = {navController.navigateUp()})
        }
    }
}