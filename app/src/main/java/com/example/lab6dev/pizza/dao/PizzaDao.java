package com.example.lab6dev.pizza.dao;

import com.example.lab6dev.pizza.model.PizzaRecipe;
import java.util.List;

// Fait par Abdelghafour
public interface PizzaDao {
    PizzaRecipe addRecipe(PizzaRecipe recipe);
    PizzaRecipe updateRecipe(PizzaRecipe recipe);
    boolean deleteRecipe(long id);
    PizzaRecipe getRecipeById(long id);
    List<PizzaRecipe> getAllRecipes();
}
