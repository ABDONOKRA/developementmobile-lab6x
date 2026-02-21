package com.example.lab6dev.pizza.repository

import com.example.lab6dev.R
import com.example.lab6dev.pizza.dao.PizzaDao
import com.example.lab6dev.pizza.model.PizzaRecipe

// Fait par Abdelghafour
class PizzaRepository private constructor() : PizzaDao {

    private val recipes = mutableListOf<PizzaRecipe>()
    private var nextId = 1L

    init {
        // Données initiales pour l'application
        addRecipe(PizzaRecipe(0, "Pizza Margherita", 8.5, R.drawable.loading, "20 min", "Tomates, mozzarella, basilic", "Une pizza classique et savoureuse.", "1. Étalez la pâte. 2. Garnir de sauce tomate, de mozzarella et de basilic. 3. Cuire au four."))
        addRecipe(PizzaRecipe(0, "Pizza Pepperoni", 10.0, R.drawable.pizza2, "25 min", "Pepperoni, fromage, sauce tomate", "Un favori de tous les temps.", "1. Préparez la pâte. 2. Ajoutez la sauce, le fromage et le pepperoni. 3. Cuire jusqu'à ce que la croûte soit dorée."))
        addRecipe(PizzaRecipe(0, "Pizza Végétarienne", 9.0, R.drawable.pizza3, "22 min", "Poivrons, oignons, olives, champignons", "Pleine de légumes frais et savoureux.", "1. Coupez les légumes. 2. Garnir la pizza avec la sauce et les légumes. 3. Cuire au four."))
        addRecipe(PizzaRecipe(0, "Pizza Quatre Fromages", 11.5, R.drawable.pizza4, "28 min", "Mozzarella, gorgonzola, parmesan, chèvre", "Un rêve pour les amateurs de fromage.", "1. Étalez la pâte. 2. Répartir les fromages sur la base. 3. Cuire jusqu'à ce que le fromage soit fondu et doré."))
        addRecipe(PizzaRecipe(0, "Pizza Hawaïenne", 10.5, R.drawable.pizza5, "26 min", "Jambon, ananas, fromage", "La pizza sucrée et salée controversée.", "1. Préparez la pâte. 2. Garnir de sauce, fromage, jambon et ananas. 3. Cuire au four."))
        addRecipe(PizzaRecipe(0, "Pizza BBQ au Poulet", 12.0, R.drawable.pizza6, "30 min", "Poulet, sauce BBQ, oignons rouges", "Une saveur fumée et audacieuse.", "1. Cuire le poulet. 2. Garnir la pizza avec la sauce BBQ, le poulet et les oignons. 3. Cuire au four."))
        addRecipe(PizzaRecipe(0, "Pizza Piquante", 11.0, R.drawable.pizza7, "27 min", "Salami piquant, piments, fromage", "Pour ceux qui aiment un peu de piquant.", "1. Étalez la pâte. 2. Garnir de sauce, fromage, salami et piments. 3. Cuire jusqu'à ce que ce soit bien chaud."))
        addRecipe(PizzaRecipe(0, "Pizza Fruits de Mer", 13.5, R.drawable.pizza8, "32 min", "Crevettes, moules, calamars, ail", "Une délicieuse pizza sur le thème de la mer.", "1. Préparez les fruits de mer. 2. Garnir la pizza avec l'ail, la sauce et les fruits de mer. 3. Cuire au four."))
        addRecipe(PizzaRecipe(0, "Pizza Calzone", 12.5, R.drawable.pizza9, "28 min", "Jambon, champignons, ricotta, mozzarella", "Une pizza pliée pleine de saveurs.", "1. Préparez la garniture. 2. Pliez la pâte en deux sur la garniture. 3. Scellez et cuire au four."))
        addRecipe(PizzaRecipe(0, "Pizza Kebab", 11.5, R.drawable.pizza10, "29 min", "Viande de kebab, salade, sauce", "Une fusion de deux plats favoris.", "1. Cuire la viande de kebab. 2. Garnir la pizza avec la viande, la salade et la sauce. 3. Servir immédiatement."))
    }

    companion object {
        @Volatile
        private var INSTANCE: PizzaRepository? = null

        fun getInstance(): PizzaRepository {
            return INSTANCE ?: synchronized(this) {
                INSTANCE ?: PizzaRepository().also { INSTANCE = it }
            }
        }
    }

    override fun addRecipe(recipe: PizzaRecipe): PizzaRecipe {
        val newRecipe = recipe.copy(id = nextId++)
        recipes.add(newRecipe)
        return newRecipe
    }

    override fun updateRecipe(recipe: PizzaRecipe): PizzaRecipe? {
        val index = recipes.indexOfFirst { it.id == recipe.id }
        if (index != -1) {
            recipes[index] = recipe
            return recipe
        }
        return null
    }

    override fun deleteRecipe(id: Long): Boolean {
        return recipes.removeIf { it.id == id }
    }

    override fun getRecipeById(id: Long): PizzaRecipe? {
        return recipes.find { it.id == id }
    }

    override fun getAllRecipes(): List<PizzaRecipe> {
        return recipes.toList()
    }
}
