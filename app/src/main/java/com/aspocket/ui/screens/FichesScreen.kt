package com.aspocket.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.ScrollableTabRow
import androidx.compose.material3.Tab
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.aspocket.data.Repo

@Composable
fun FichesScreen(nav: NavController) {
    val ctx = LocalContext.current
    val categories = remember { Repo.categories(ctx) }
    var selected by remember { mutableStateOf(categories.firstOrNull()) }

    Column(Modifier.fillMaxSize()) {
        ScrollableTabRow(selectedTabIndex = categories.indexOf(selected)) {
            categories.forEach { cat ->
                Tab(selected = selected == cat, onClick = { selected = cat }, text = { Text(cat) })
            }
        }

        val fiches = remember(selected) { selected?.let { Repo.byCategory(ctx, it) } ?: emptyList() }

        LazyColumn(Modifier.fillMaxSize().padding(8.dp)) {
            items(fiches) { f ->
                ElevatedCard(
                    modifier = Modifier
                        .padding(vertical = 4.dp)
                        .clickable { nav.navigate("fiche/${f.id}") }
                ) {
                    Column(Modifier.padding(16.dp)) {
                        Text(f.title)
                        Text(f.summary, maxLines = 2)
                        TextButton(onClick = { nav.navigate("fiche/${f.id}") }) { Text("Voir") }
                    }
                }
            }
        }
    }
}
