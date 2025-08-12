package com.aspocket.ui

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.aspocket.ui.screens.AstucesScreen
import com.aspocket.ui.screens.FicheDetailScreen
import com.aspocket.ui.screens.FichesScreen
import com.aspocket.ui.screens.MajScreen
import com.aspocket.ui.screens.ReferentielScreen

private sealed class Dest(
    val route: String,
    val label: String,
    val icon: ImageVector
) {
    data object Referentiel : Dest("referentiel", "Référentiel", Icons.Filled.Book)
    data object Fiches      : Dest("fiches", "Fiches", Icons.Filled.List)
    data object Astuces     : Dest("astuces", "Astuces", Icons.Filled.AutoAwesome)
    data object Maj         : Dest("maj", "MAJ", Icons.Filled.Update)
}

@Composable
fun AppRoot() {
    val nav: NavHostController = rememberNavController()
    val items = listOf(Dest.Referentiel, Dest.Fiches, Dest.Astuces, Dest.Maj)

    Scaffold(
        bottomBar = {
            NavigationBar {
                val backStackEntry by nav.currentBackStackEntryAsState()
                val currentRoute = backStackEntry?.destination?.route
                items.forEach { dest ->
                    NavigationBarItem(
                        selected = currentRoute == dest.route,
                        onClick = {
                            nav.navigate(dest.route) {
                                popUpTo(nav.graph.startDestinationId) { saveState = true }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        icon = { Icon(dest.icon, contentDescription = dest.label) },
                        label = { Text(dest.label) }
                    )
                }
            }
        }
    ) { padding ->
        NavHost(
            navController = nav,
            startDestination = Dest.Fiches.route,
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
        ) {
            composable(Dest.Referentiel.route) { ReferentielScreen() }
            // ⚠️ FichesScreen attend un NavController dans ton projet
            composable(Dest.Fiches.route) { FichesScreen(nav) }
            composable("fiche/{id}") { backStack ->
                val id = backStack.arguments?.getString("id").orEmpty()
                FicheDetailScreen(id)
            }
            composable(Dest.Astuces.route) { AstucesScreen() }
            composable(Dest.Maj.route) { MajScreen() }
        }
    }
}
