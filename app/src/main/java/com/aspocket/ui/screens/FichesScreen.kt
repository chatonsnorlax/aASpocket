package com.aspocket.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.aspocket.data.Repo

@Composable
fun FichesScreen() {
    val ctx = LocalContext.current
    val categories = remember { Repo.categories(ctx) }
    var selected by remember { mutableStateOf(categories.firstOrNull()) }
    Column(Modifier.fillMaxSize()) {
        ScrollableTabRow(selectedTabIndex = categories.indexOf(selected)) {
            categories.forEachIndexed { index, cat ->
                Tab(selected = selected == cat, onClick = { selected = cat }, text = { Text(cat) })
            }
        }
        val fiches = remember(selected) { selected?.let { Repo.byCategory(ctx, it) } ?: emptyList() }
        LazyColumn(Modifier.fillMaxSize().padding(8.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
            items(fiches) { f ->
                ElevatedCard(Modifier.fillMaxWidth().clickable {
                    // Navigate by building route; parent NavHost provided in AppRoot
                    // For simplicity, we use a shared navController provided via Local
                }) {
                    Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(6.dp)) {
                        Text(f.title, style = MaterialTheme.typography.titleMedium)
                        Text(f.summary, style = MaterialTheme.typography.bodyMedium, maxLines = 2)
                        TextButton(onClick = {
                            com.aspocket.ui.navigateToFiche(f.id)
                        }) { Text("Voir") }
                    }
                }
            }
        }
    }
}