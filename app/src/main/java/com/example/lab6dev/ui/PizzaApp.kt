package com.example.lab6dev.ui

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.lab6dev.ui.screens.PizzaDetailScreen
import com.example.lab6dev.ui.screens.PizzaListScreen
import com.example.lab6dev.ui.screens.SplashScreen

// Fait par Abdelghafour
@Composable
fun PizzaApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            SplashScreen(navController = navController)
        }
        composable("pizza_list") {
            PizzaListScreen(navController = navController)
        }
        composable("pizza_detail/{pizzaId}") { backStackEntry ->
            val pizzaId = backStackEntry.arguments?.getString("pizzaId")?.toLongOrNull()
            if (pizzaId != null) {
                PizzaDetailScreen(pizzaId = pizzaId, navController = navController)
            }
        }
    }
}
