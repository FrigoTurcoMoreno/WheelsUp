package com.mftjc.wheelsup.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import com.mftjc.wheelsup.model.Car

@Composable
fun HomeScreen(
    padding: PaddingValues,
    navHostController: NavHostController
) {
    val categoriesList = listOf(
        "Sedans",
        "SUVs",
        "Electric",
        "Hybrid",
        "Sport",
        "Race",
        "Antique"
    )

    val cars = listOf(
        Car(
            manufacturer = "Subaru",
            model = "Impreza WRX"
        ),
        Car(
            manufacturer = "Mitsubishi",
            model = "Lancer Evolution IV"
        ),
        Car(
            manufacturer = "Honda",
            model = "Civic"
        ),
        Car(
            manufacturer = "Honda",
            model = "Civic"
        ),
        Car(
            manufacturer = "Honda",
            model = "Civic"
        ),
        Car(
            manufacturer = "Honda",
            model = "Civic"
        ),
        Car(
            manufacturer = "Honda",
            model = "Civic"
        ),
    )

    //faccio una colonna, in modo da avere tutto ordinato in verticale
    Column (
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
    ){
        //in cima inserisco una riga in cui si possono vedere tutte le categorie
        LazyRow (
            modifier = Modifier
                .fillMaxWidth()
                .fillMaxHeight(0.2f)
                .shadow(
                    elevation = 2.dp
                ),
            verticalAlignment = Alignment.CenterVertically
        ){
            items(categoriesList){ category ->
                Card(
                    modifier = Modifier
                        .padding(20.dp)
                        .height(120.dp)
                        .width(120.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .fillMaxSize(),
                        contentAlignment = Alignment.Center
                    ){
                        Text(category)
                    }
                }

            }
        }

        //mostro in colonna tutte le auto che l'utente ha scelto
        LazyColumn(
            modifier = Modifier
                .fillMaxSize(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            items(cars){car ->
                Card(
                    modifier = Modifier
                        .width(500.dp)
                        .height(175.dp)
                        .padding(20.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxSize()
                            .clickable {
                                //se la card viene cliccata, apro il Car Screen
                                navHostController.navigate(Screen.CarScreen.route)
                            },
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = car.manufacturer
                        )
                        Text(
                            text = car.model
                        )
                        Text(
                            text = "cc: ${car.cc}"
                        )
                    }
                }
            }
        }
    }
}