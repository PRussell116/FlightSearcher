package com.example.flightsearcher.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable

import androidx.compose.ui.Alignment.Companion.CenterVertically
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun FavouriteCard(depart: String,departCode: String, arrive:String, arriveCode:String,checked: Boolean){
    Card(colors = CardDefaults.cardColors(MaterialTheme.colorScheme.surfaceVariant)) {
        Row(modifier = Modifier.padding(horizontal = 15.dp,vertical = 20.dp)) {
            Column() {
                Text(text = "Depart", fontWeight = FontWeight.ExtraBold)

                Row() {
                    Text(text = departCode,fontWeight = FontWeight.SemiBold, modifier = Modifier
                        .padding(5.dp)
                        .align(CenterVertically))

                    Text(text = depart, modifier = Modifier.align(CenterVertically))

                }

                Text(text = "Arrive", fontWeight = FontWeight.ExtraBold)

                Row() {
                    Text(text = arriveCode, fontWeight = FontWeight.SemiBold,modifier = Modifier
                        .padding(5.dp)
                        .align(CenterVertically))
                    Text(text = arrive, modifier = Modifier.align(CenterVertically))
                }

            }
            IconButton(onClick = { /*TODO*/ }, modifier = Modifier.align(CenterVertically)) {
                Icon(
                    imageVector = Icons.Filled.Star,
                    modifier = Modifier.align(CenterVertically),
                    contentDescription = "Favorite / Unfavorite flight",
                    tint = if(checked) Color(255,215,0) else Color.LightGray

                )
            }
        }
    }
}

@Preview
@Composable
fun FaveCardPreview(){
    FavouriteCard(depart = "London Heathrow Airport", departCode ="HTR" , arrive = "Dublin Airport", arriveCode = "DUB",false)

}
@Preview
@Composable
fun FaveCardPreview2(){
    FavouriteCard(depart = "London Heathrow Airport", departCode ="HTR" , arrive = "Dublin Airport", arriveCode = "DUB",true)

}