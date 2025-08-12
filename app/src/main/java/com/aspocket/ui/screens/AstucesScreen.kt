package com.aspocket.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun AstucesScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Astuces de terrain (à venir)", style = MaterialTheme.typography.titleLarge)
        Text("Vous pourrez bientôt poster des astuces; elles seront vérifiées avant publication.")
        OutlinedButton(onClick = { }) { Text("Partager une astuce") }
    }
}