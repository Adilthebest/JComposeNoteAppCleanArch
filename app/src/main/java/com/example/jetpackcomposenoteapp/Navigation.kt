package com.example.jetpackcomposenoteapp

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavType
import androidx.navigation.Navigation
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.jetpackcomposenoteapp.feature_note.presentation.screen.DetailScreen
import com.example.jetpackcomposenoteapp.feature_note.presentation.screen.MainScreen
import com.example.jetpackcomposenoteapp.feature_note.presentation.screen.SecondScreen

@Preview
@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screens.MainScreen.route
    ) {
composable(Screens.MainScreen.route) {
    MainScreen {
        navController.navigate(Screens.DetailScreen.route + "/${it?.id ?: -1}") {

        }
    }
}
    composable(Screens.SecondScreen.route) {
        SecondScreen()
    }
    composable(
        Screens.DetailScreen.route + "/{id}",
        arguments = listOf(navArgument("id") { type = NavType.IntType }),
    ) {
        DetailScreen(selected = it.arguments?.getInt("Id") ?: -1) {
            navController.navigateUp()
        }

    }

    }

}