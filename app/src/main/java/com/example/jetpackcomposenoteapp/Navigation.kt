package com.example.jetpackcomposenoteapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.jetpackcomposenoteapp.feature_note.presentation.screen.DetailScreen
import com.example.jetpackcomposenoteapp.feature_note.presentation.screen.MainScreen

@Preview
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {
        composable(Screens.MainScreen.route) {
            MainScreen (navController)
        }
        composable(Screens.DetailScreen.route){
            DetailScreen() { navController.navigate(Screens.MainScreen.route) }
        }
    }
}