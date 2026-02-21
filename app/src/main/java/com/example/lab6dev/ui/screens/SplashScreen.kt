package com.example.lab6dev.ui.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.size
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.lab6dev.R
import kotlinx.coroutines.delay

@Composable
fun SplashScreen(navController: NavController) {
    LaunchedEffect(Unit) {
        delay(3000) // Increased delay for better user experience
        navController.navigate("pizza_list") {
            popUpTo("splash") { inclusive = true }
        }
    }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFFF4B4B)), // Red background color
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Image(
            painter = painterResource(id = R.drawable.loading),
            contentDescription = "Splash Screen Image",
            modifier = Modifier.size(200.dp) // Larger image size
        )
        Spacer(modifier = Modifier.height(24.dp))
        Text(
            text = "Pizza Recipes",
            style = TextStyle(
                color = Color.White,
                fontSize = 48.sp,
                fontFamily = FontFamily.Cursive,
                fontWeight = FontWeight.Bold
            )
        )
        Text(
            text = "Make your Pizza",
            style = TextStyle(
                color = Color.White,
                fontSize = 24.sp,
                fontFamily = FontFamily.SansSerif
            )
        )
        Spacer(modifier = Modifier.height(48.dp))
        CircularProgressIndicator(
            color = Color(0xFF00C853) // Teal progress indicator
        )
    }
}