package com.aspocket.ui

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AutoAwesome
import androidx.compose.material.icons.filled.Book
import androidx.compose.material.icons.filled.Update
import androidx.compose.material3.Icon
import androidx.compose.material3.ListItem
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun AppRoot() {
    val navController = rememberNavController()

    Scaffold { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = "home",
            modifier = Modifier.padding(innerPadding)
        ) {
            composable("home") { HomeScreen(navController) }
            composable("referentiel") { ReferentielScreen() }
            composable("fiches") { FichesScreen() }
            composable("astuces") { AstucesScreen() }
            composable("maj") { MajScreen() }
        }
    }
}

@Composable
fun HomeScreen(navController: NavHostController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        item {
            ListItem(
                headlineText = { Text("Référentiel") },
                leadingContent = {
                    Icon(
                        imageVector = Icons.Filled.Book,
                        contentDescription = "Référentiel"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                supportingText = { Text("Accédez au référentiel officiel") },
                trailingContent = {},
                overlineText = null
            )
        }

        item {
            ListItem(
                headlineText = { Text("Fiches") },
                leadingContent = {
                    Icon(
                        imageVector = Icons.Filled.AutoAwesome,
                        contentDescription = "Fiches"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                supportingText = { Text("Guides pratiques et visuels") },
                trailingContent = {},
                overlineText = null
            )
        }

        item {
            ListItem(
                headlineText = { Text("Mises à jour") },
                leadingContent = {
                    Icon(
                        imageVector = Icons.Filled.Update,
                        contentDescription = "Mises à jour"
                    )
                },
                modifier = Modifier.fillMaxWidth(),
                supportingText = { Text("Dernières infos sur le métier") },
                trailingContent = {},
                overlineText = null
            )
        }
    }
}
