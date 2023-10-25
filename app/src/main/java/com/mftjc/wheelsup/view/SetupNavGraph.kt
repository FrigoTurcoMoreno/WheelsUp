package com.mftjc.wheelsup.view

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable

//creo un setupnavgraph per poter navigare negli Screen secondari
//per esempio quando clicco su una macchina nella Home Screen
//per vedere i suoi dati, oppure quando clicco su una categoria
//per vedere le auto che ne fanno parte
@Composable
fun SetupNavGraph(
    navHostController: NavHostController
) {
    NavHost(
        navHostController,
        startDestination = Screen.MainScreen.route
    ){
        composable(
            route = Screen.MainScreen.route
        ){
            MainScreen(navHostController)
        }
        composable(
            route = Screen.CarScreen.route
        ){
            CarScreen(navHostController)
        }
    }

}