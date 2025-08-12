package com.aspocket.ui.screens

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Divider
import androidx.compose.material3.ListItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

data class RefItem(val title: String, val route: String)

private val referentielItems = listOf(
    RefItem(title = "Traçabilité – dossier de soins", route = "ref_tracabilite"),
    RefItem(title = "Hygiène – EPI au soin", route = "ref_hygiene_epi"),
    RefItem(title = "Circuit du médicament", route = "ref_medicament"),
    RefItem(title = "Règles de sécurité", route = "ref_securite")
)

@Composable
fun ReferentielScreen(
    onItemClick: (String) -> Unit = {}
) {
    Scaffold(
        topBar = { TopAppBar(title = { Text("Référentiel") }) }
    ) { padding ->
        Column(Modifier.padding(padding).padding(16.dp)) {
            referentielItems.forEach { item ->
                ListItem(
                    headlineContent = { Text(item.title) },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clickable { onItemClick(item.route) }
                )
                Divider()
            }
        }
    }
}
