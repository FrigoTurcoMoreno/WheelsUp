package com.mftjc.wheelsup.view

//creo una sealed class per creare degli oggetti uguali
//di cui cambia solo il route per navigare
//(solo per avere un codice più pulito,
// perchè mi permette di non scrivere ogni volta
// il route, rischiando di sbagliare)
sealed class Screen(val route: String) {
    object MainScreen : Screen(route = "main_screen")
    object CarScreen : Screen(route = "car_screen")
}