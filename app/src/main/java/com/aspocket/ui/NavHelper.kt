package com.aspocket.ui

import androidx.compose.runtime.staticCompositionLocalOf
import androidx.navigation.NavHostController

val LocalNavController = staticCompositionLocalOf<NavHostController> { error("No NavController") }

fun navigateToFiche(id: String) {
    LocalNavController.current.navigate("fiche/$id")
}