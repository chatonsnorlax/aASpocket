package com.aspocket.data

import android.content.Context
import com.aspocket.model.Fiche
import kotlinx.serialization.json.Json
import kotlinx.serialization.decodeFromString

object Repo {
    private var cached: List<Fiche>? = null

    fun fiches(ctx: Context): List<Fiche> {
        cached?.let { return it }
        val json = ctx.assets.open("fiches.json").bufferedReader().use { it.readText() }
        val data = Json { ignoreUnknownKeys = true }.decodeFromString<List<Fiche>>(json)
        cached = data
        return data
    }

    fun ficheById(ctx: Context, id: String): Fiche? = fiches(ctx).firstOrNull { it.id == id }
    fun categories(ctx: Context): List<String> = fiches(ctx).map { it.category }.distinct()
    fun byCategory(ctx: Context, cat: String): List<Fiche> = fiches(ctx).filter { it.category == cat }
}