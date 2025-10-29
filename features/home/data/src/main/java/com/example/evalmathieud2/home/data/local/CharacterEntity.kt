package com.example.evalmathieud2.home.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entité Room pour le cache local des personnages Dragon Ball.
 */
@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val affiliation: String,
    val deletedAt: String?
)
