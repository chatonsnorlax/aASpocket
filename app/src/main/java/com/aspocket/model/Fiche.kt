package com.aspocket.model

import kotlinx.serialization.Serializable

@Serializable
data class Fiche(
    val id: String,
    val category: String,
    val title: String,
    val summary: String,
    val content: String,
    val tips: List<String> = emptyList(),
    val images: List<String> = emptyList()
)