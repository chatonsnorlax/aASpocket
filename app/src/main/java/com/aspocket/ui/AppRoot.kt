package com.aspocket.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController

sealed class Dest(val route: String, val label: String, val icon: ImageVector) {
    object Referentiel: Dest("referentiel", "Référentiel", Icons.Filled.Book)
    object Fiches: Dest("fiches", "Fiches", Icons.Filled.List)
    object Astuces: Dest("astuces", "Astuces", Icons.Filled.AutoAwesome)
    object Maj: Dest("maj", "MAJ", Icons.Filled.Update)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppRoot() {
    val nav = rememberNavController()
    val items = listOf(Dest.Referentiel, Dest.Fiches, Dest.Astuces, Dest.Maj)
    val nav = rememberNavController()
    CompositionLocalProvider(LocalNavController provides nav) {
        Scaffold(
        bottomBar = {
            NavigationBar {
                val backStackEntry by nav.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route
                items.forEach { dest ->
                    NavigationBarItem(
                        selected = currentRoute == dest.route,
                        onClick = { nav.navigate(dest.route) { popUpTo(nav.graph.startDestinationId) { saveState=true }; launchSingleTop=true; restoreState=true } },
                        icon = { Icon(dest.icon, contentDescription = dest.label) },
                        label = { Text(dest.label) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(nav, startDestination = Dest.Fiches.route, modifier = Modifier.fillMaxSize().padding(padding)) {
            composable(Dest.Referentiel.route) { com.aspocket.ui.screens.ReferentielScreen() }
            composable(Dest.Fiches.route) { com.aspocket.ui.screens.FichesScreen() }
            composable("fiche/{id}") { backStack ->
                val id = backStack.arguments?.getString("id") ?: ""
                com.aspocket.ui.screens.FicheDetailScreen(id)
            }
            composable(Dest.Astuces.route) { com.aspocket.ui.screens.AstucesScreen() }
            composable(Dest.Maj.route) { com.aspocket.ui.screens.MajScreen() }
        }
    }
}
    }