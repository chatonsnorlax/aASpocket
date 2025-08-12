package com.aspocket.ui.screens

    import androidx.compose.foundation.layout.*
    import androidx.compose.material3.*
    import androidx.compose.runtime.*
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.unit.dp
    import androidx.compose.ui.platform.LocalUriHandler

private val referentielSections = listOf(
    "Traçabilité (dossier de soins)",
    "Hygiène",
    "EPI",
    "Auxiliaire"
)


    @Composable
    fun ReferentielScreen() {
        val uri = LocalUriHandler.current
        Column(Modifier.fillMaxSize().padding(16.dp), verticalArrangement = Arrangement.spacedBy(12.dp)) {
            Text("Référentiel Aide-Soignant – Synthèse rapide", style = MaterialTheme.typography.titleLarge)
            Text(
                "Rappels : champs d'intervention, actes autorisés/sous délégation, traçabilité, confidentialité. " +
                "Toujours se référer au protocole de l'établissement. Cette app est un support pédagogique.",
                style = MaterialTheme.typography.bodyMedium
            )
            OutlinedCard(Modifier.fillMaxWidth()) {
                Column(Modifier.padding(16.dp), verticalArrangement = Arrangement.spacedBy(8.dp)) {
                    Text("Points clés", style = MaterialTheme.typography.titleMedium)
                    Text("• Respect du rôle propre et des délégations.
• Traçabilité dans le dossier de soins.
• Hygiène et EPI adaptés aux situations.")
                }
            }
            Button(onClick = {
                // Lien officiel placeholder – à remplacer par URL du référentiel en vigueur
                uri.openUri("https://solidarites-sante.gouv.fr/")
            }, modifier = Modifier.align(Alignment.CenterHorizontally)) {
                Text("Consulter le référentiel officiel")
            }
            Text("Dernière mise à jour : 01/08/2025", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
        }
    }
