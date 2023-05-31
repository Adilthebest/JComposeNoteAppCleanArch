package com.example.jetpackcomposenoteapp

sealed class Screens(val route:String) {
  object MainScreen : Screens("main_screen")
  object SecondScreen : Screens("second_screen")
  object DetailScreen : Screens("detail_screen")
}