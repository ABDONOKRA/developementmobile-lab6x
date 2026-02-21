package com.example.lab6dev.pizza.dao

import com.example.lab6dev.pizza.model.PizzaRecipe

// Fait par Abdelghafour
interface PizzaDao {
    fun addRecipe(recipe: PizzaRecipe): PizzaRecipe
    fun updateRecipe(recipe: PizzaRecipe): PizzaRecipe?
    fun deleteRecipe(id: Long): Boolean
    fun getRecipeById(id: Long): PizzaRecipe?
    fun getAllRecipes(): List<PizzaRecipe>
}
