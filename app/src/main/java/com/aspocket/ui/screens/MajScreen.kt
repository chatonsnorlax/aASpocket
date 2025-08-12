package com.aspocket.ui.screens

import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun MajScreen() {
    Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
        Text("Mises à jour du métier (à venir)", style = MaterialTheme.typography.titleLarge)
        Text("Retrouvez ici des brèves datées et sourcées sur les évolutions de la profession.")
    }
}