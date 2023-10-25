package com.mftjc.wheelsup.view

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material.icons.outlined.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.navigation.NavHostController

//screen principale, dal quale navighiamo nei 3 screen più importanti
//(home, search, profile)
@Composable
fun MainScreen(
    navHostController: NavHostController
) {
    //variabile che contiene il nome dello screen
    //è uno State perchè deve essere modificabile durante la ricomposizione
    var iconSelected by remember { mutableStateOf("home") }

    //utilizzo lo scaffold per inserire la bottom bar
    Scaffold (
        bottomBar = {
            //nella navigation bar ho un item per ogni screen principale
            //quando clicco su un item, modifico l'iconSelected
            NavigationBar{
                NavigationBarItem(
                    selected = "home" == iconSelected,
                    onClick = {
                        iconSelected = "home"
                    },
                    icon = {
                        //se l'iconSelected è uguale e quindi è attualmente scelta, l'icona sarà ripiena
                        //altrimenti sarà vuota
                        if (iconSelected == "home") Icon(Icons.Filled.Home, "home screen selected")
                        else Icon(Icons.Outlined.Home, "home screen not selected")
                    },
                    label = {
                        Text("Home")
                    }
                )
                NavigationBarItem(
                    selected = "search" == iconSelected,
                    onClick = {
                        iconSelected = "search"
                    },
                    icon = {
                        if (iconSelected == "search") Icon(Icons.Filled.Search, "search screen selected")
                        else Icon(Icons.Outlined.Search, "search screen not selected")
                    },
                    label = {
                        Text("Search")
                    }
                )
                NavigationBarItem(
                    selected = "profile" == iconSelected,
                    onClick = {
                        iconSelected = "profile"
                    },
                    icon = {
                        if (iconSelected == "profile") Icon(Icons.Filled.Person, "profile screen selected")
                        else Icon(Icons.Outlined.Person, "profile screen not selected")
                    },
                    label = {
                        Text("Profile")
                    }
                )
            }
        }
    ) {

        //in base all'iconSelected, utilizzo una funzione composable, che mostra lo Screen dell'item,
        //nello spazio che rimane nel MainScreen
        //così da avere sempre disponibile la navigation bar
        //l'idea è di cambiare soltanto la parte superiore alla nav bar
        //per esempio se clicco sull'icona della home, richiama la funzione della Home Screen,
        //ma se clicco sul search, viene richiamata la funzione del Search Screen al posto della Home Screen
        when (iconSelected) {
            "home" -> HomeScreen(it, navHostController)
            "search" -> SearchScreen(it)
            "profile" -> ProfileScreen(it)
        }
    }
}