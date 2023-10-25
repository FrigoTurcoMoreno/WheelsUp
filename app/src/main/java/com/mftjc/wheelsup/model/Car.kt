package com.mftjc.wheelsup.model

data class Car(
    val manufacturer: String = "",
    val model: String = "",
    val year: String = "",
    val cc: Int = 0,
    val category: String = "",
    val cost: Int = 0
)
