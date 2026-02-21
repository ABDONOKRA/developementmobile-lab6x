@file:OptIn(androidx.compose.material3.ExperimentalMaterial3Api::class)

package com.example.lab6dev.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab6dev.pizza.model.PizzaRecipe
import com.example.lab6dev.pizza.repository.PizzaRepository

// Fait par Abdelghafour
@Composable
fun PizzaListScreen(navController: NavController) {
    val context = LocalContext.current
    val pizzaRepository = PizzaRepository.getInstance()
    val pizzas = pizzaRepository.getAllRecipes()

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Pizza Recipes by Abdelghafour", color = Color.White) },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFE91E63) // Couleur rose
                ),
                actions = {
                    IconButton(onClick = {
                        val sendIntent: Intent = Intent().apply {
                            action = Intent.ACTION_SEND
                            putExtra(Intent.EXTRA_TEXT, "Découvrez ces incroyables recettes de pizza !")
                            type = "text/plain"
                        }
                        val shareIntent = Intent.createChooser(sendIntent, null)
                        context.startActivity(shareIntent)
                    }) {
                        Icon(Icons.Filled.Share, contentDescription = "Partager", tint = Color.White)
                    }
                }
            )
        }
    ) { padding ->
        LazyColumn(modifier = Modifier.padding(padding)) {
            items(pizzas) { pizza ->
                PizzaRow(pizza = pizza, onClick = {
                    navController.navigate("pizza_detail/${pizza.id}")
                })
            }
        }
    }
}

@Composable
fun PizzaRow(pizza: PizzaRecipe, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable(onClick = onClick),
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
    ) {
        Row(verticalAlignment = Alignment.CenterVertically) {
            Image(
                painter = painterResource(id = pizza.imageRes),
                contentDescription = null,
                modifier = Modifier.size(120.dp),
                contentScale = ContentScale.Crop
            )
            Column(modifier = Modifier.padding(12.dp)) {
                Text(pizza.name, fontWeight = FontWeight.Bold, fontSize = 18.sp)
                Text("${pizza.duration} • ${pizza.price} €", fontSize = 14.sp, color = Color.Gray)
            }
        }
    }
}
