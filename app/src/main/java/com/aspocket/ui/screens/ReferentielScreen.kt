package com.aspocket.ui.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp

// Sections affichées (tout en texte, bien quoté)
private val referentielSections = listOf(
    "Traçabilité (dossier de soins)",
    "Hygiène",
    "EPI",
    "Auxiliaire"
)

/**
 * Écran Référentiel
 */
@Composable
fun ReferentielScreen() {
    val uri = LocalUriHandler.current
    val scroll = rememberScrollState()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(scroll)
            .padding(PaddingValues(16.dp)),
        verticalArrangement = Arrangement.spacedBy(12.dp)
    ) {
        Text(
            text = "Référentiel Aide-Soignant – Synthèse rapide",
            style = MaterialTheme.typography.titleLarge
        )

        Text(
            text = "Rappels : champs d’intervention, actes autorisés/sous délégation, traçabilité, confidentialité. " +
                    "Toujours se référer au protocole de l’établissement. Cette app est un support pédagogique.",
            style = MaterialTheme.typography.bodyMedium
        )

        OutlinedCard(
            modifier = Modifier.fillMaxWidth()
        ) {
            Column(
                modifier = Modifier
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                Text(
                    text = "Points clés",
                    style = MaterialTheme.typography.titleMedium
                )

                // Liste des sections
                referentielSections.forEach { item ->
                    Text(text = "• $item", style = MaterialTheme.typography.bodyMedium)
                }

                // Rappels complémentaires
                Text(text = "• Respect du rôle propre et des délégations.")
                Text(text = "• Traçabilité dans le dossier de soins.")
                Text(text = "• Hygiène et EPI adaptés aux situations.")
            }
        }

        Button(
            onClick = {
                // Lien officiel (à adapter si besoin)
                uri.openUri("https://solidarites-sante.gouv.fr/")
            },
            modifier = Modifier.align(Alignment.CenterHorizontally)
        ) {
            Text(text = "Consulter le référentiel officiel")
        }

        Text(
            text = "Dernière mise à jour : 01/08/2025",
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )
    }
}
