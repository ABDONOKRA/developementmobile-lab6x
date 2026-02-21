package com.example.lab6dev.ui

import androidx.compose.runtime.Composable
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.lab6dev.ui.screens.PizzaDetailScreen
import com.example.lab6dev.ui.screens.PizzaListScreen
import com.example.lab6dev.ui.screens.SplashScreen

@Composable
fun PizzaApp() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "splash") {
        composable("splash") {
            com.example.lab6dev.ui.screens.SplashScreen(navController = navController)
        }
        composable("pizza_list") {
            com.example.lab6dev.ui.screens.PizzaListScreen(navController = navController)
        }
        composable(
            "pizza_detail/{pizzaId}",
            arguments = listOf(navArgument("pizzaId") { type = NavType.LongType })
        ) { backStackEntry ->
            val pizzaId = backStackEntry.arguments?.getLong("pizzaId")
            if (pizzaId != null) {
                com.example.lab6dev.ui.screens.PizzaDetailScreen(pizzaId = pizzaId, navController = navController)
            }
        }
    }
}
