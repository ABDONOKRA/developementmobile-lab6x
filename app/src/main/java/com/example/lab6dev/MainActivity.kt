package com.example.lab6dev

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.lab6dev.ui.PizzaApp
import com.example.lab6dev.ui.theme.Lab6DevTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Lab6DevTheme {
                PizzaApp()
            }
        }
    }
}
