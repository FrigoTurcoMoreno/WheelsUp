package com.mftjc.wheelsup

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.mftjc.wheelsup.view.SetupNavGraph

class MainActivity : ComponentActivity() {
    //creo un navhost controller che mi serve per navigare
    //negli screen secondari
    private lateinit var navHostController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            navHostController = rememberNavController()
            SetupNavGraph(navHostController)
        }
    }
}