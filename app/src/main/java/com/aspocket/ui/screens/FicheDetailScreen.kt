package com.aspocket.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.aspocket.data.Repo

@Composable
fun FicheDetailScreen(id: String) {
    val ctx = LocalContext.current
    val fiche = remember(id) { Repo.ficheById(ctx, id) }
    if (fiche == null) {
        Box(Modifier.fillMaxSize(), contentAlignment = androidx.compose.ui.Alignment.Center) {
            Text("Fiche introuvable")
        }
        return
    }
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
        Text(fiche.title, style = MaterialTheme.typography.titleLarge)
        Text(fiche.content, style = MaterialTheme.typography.bodyMedium)
        if (fiche.tips.isNotEmpty()) {
            Divider()
            Text("À retenir", style = MaterialTheme.typography.titleMedium)
            fiche.tips.forEach { t -> Text("• " + t) }
        }
    }
}