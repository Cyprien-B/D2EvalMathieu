package com.example.evalmathieud2.home.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * Entité Room représentant un personnage Dragon Ball dans la base de données locale.
 *
 * Cette entité est utilisée pour le cache local des personnages récupérés depuis l'API.
 *
 * @property id Identifiant unique du personnage (clé primaire)
 * @property name Nom du personnage
 * @property ki Niveau de Ki actuel
 * @property maxKi Niveau de Ki maximal
 * @property race Race (Saiyan, Namekian, Human, etc.)
 * @property gender Genre (Male, Female)
 * @property description Histoire du personnage
 * @property image URL de l'image
 * @property affiliation Affiliation (Z Fighter, Army of Frieza, etc.)
 * @property deletedAt Date de suppression, null si actif
 * @see com.example.evalmathieud2.home.domain.Character
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

