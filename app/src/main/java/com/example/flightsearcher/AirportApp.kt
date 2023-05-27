package com.example.flightsearcher

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.example.flightsearcher.ui.navigation.AirportNavHost

@Composable
fun AirportApp(navController: NavHostController = rememberNavController()){
    AirportNavHost(navController = navController)
}

@Composable
fun AirportTopBar(title:String,canNavigateBack: Boolean,modifier : Modifier = Modifier,navigateUp: ()-> Unit ={}){
    if(canNavigateBack){
        TopAppBar(
            title = { Text("title") },
            modifier = modifier,
            navigationIcon = {
                IconButton(onClick = navigateUp) {
                    Icon(imageVector = Icons.Filled.ArrowBack, contentDescription = "Back button")
                }
            }
        )

    }else{
        TopAppBar(title = { Text(text = "Title")},modifier= modifier)

    }
}