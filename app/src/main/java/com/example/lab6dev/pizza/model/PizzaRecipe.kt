package com.example.lab6dev.pizza.model

// Fait par Abdelghafour
data class PizzaRecipe(
    val id: Long,
    var name: String,
    var price: Double,
    var imageRes: Int,
    var duration: String,
    var ingredients: String,
    var description: String,
    var steps: String
)
