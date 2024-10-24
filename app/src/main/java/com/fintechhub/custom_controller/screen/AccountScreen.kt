package com.fintechhub.custom_controller.screen

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController

@Composable
fun AccountScreen(navController: NavHostController){
    Text(text = "account", color = Color.Black)
}