package com.example.lab6dev.ui.screens

import android.content.Intent
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab6dev.pizza.repository.PizzaRepository

// Fait par Abdelghafour
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PizzaDetailScreen(pizzaId: Long, navController: NavController) {
    val context = LocalContext.current
    val pizza = PizzaRepository.getInstance().getRecipeById(pizzaId)

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text(pizza?.name ?: "Détail de la Pizza", color = Color.White) },
                navigationIcon = {
                    IconButton(onClick = { navController.popBackStack() }) {
                        Icon(Icons.Filled.ArrowBack, contentDescription = "Retour", tint = Color.White)
                    }
                },
                actions = {
                    IconButton(onClick = {
                        pizza?.let {
                            val sendIntent: Intent = Intent().apply {
                                action = Intent.ACTION_SEND
                                putExtra(Intent.EXTRA_TEXT, "Regarde cette recette de pizza : ${it.name}\n${it.description}")
                                type = "text/plain"
                            }
                            val shareIntent = Intent.createChooser(sendIntent, null)
                            context.startActivity(shareIntent)
                        }
                    }) {
                        Icon(Icons.Filled.Share, contentDescription = "Partager", tint = Color.White)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = Color(0xFFE91E63) // Couleur rose
                )
            )
        }
    ) { padding ->
        if (pizza != null) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(padding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                Image(
                    painter = painterResource(id = pizza.imageRes),
                    contentDescription = null,
                    modifier = Modifier
                        .height(250.dp)
                        .fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(pizza.name, fontWeight = FontWeight.Bold, fontSize = 24.sp)
                Text("${pizza.duration} • ${pizza.price} €", fontSize = 16.sp, color = Color.Gray)
                Spacer(modifier = Modifier.height(16.dp))
                Text("Description :", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(pizza.description, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Text("Ingrédients :", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(pizza.ingredients, fontSize = 16.sp)
                Spacer(modifier = Modifier.height(16.dp))
                Text("Étapes :", fontWeight = FontWeight.Bold, fontSize = 20.sp)
                Text(pizza.steps, fontSize = 16.sp)
            }
        } else {
            Text("Pizza non trouvée !", modifier = Modifier.padding(padding))
        }
    }
}
