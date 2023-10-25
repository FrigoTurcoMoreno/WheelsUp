package com.mftjc.wheelsup.view

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CarScreen(
    navHostController: NavHostController
) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                //il titolo verrà cambiato con il nome della casa produttrice
                title = {
                    Text("Car Name")
                },
                //inserisco una freccia per tornare alla home screen
                navigationIcon = {
                    IconButton(
                        onClick = {
                            //utilizzo il popBackStack perchè così
                            //questo Screen non rimane nello stack
                            //e quindi non posso tornarci
                            navHostController.popBackStack()
                        },
                    ){
                        Icon(Icons.Default.ArrowBack, "back to home screen")
                    }
                }
            )
        }
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(it),
            contentAlignment = Alignment.Center
        ){
            Text(
                text = "Car Screen",
                fontSize = 25.sp
            )
        }
    }

}