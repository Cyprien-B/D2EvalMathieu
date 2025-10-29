package com.example.evalmathieud2.home.domain
/**
 * Modèle métier d'un personnage Dragon Ball.
 *
 * @property id Identifiant unique
 * @property name Nom du personnage
 * @property ki Niveau de Ki actuel
 * @property maxKi Niveau de Ki maximal
 * @property race Race (Saiyan, Namekian, Human, etc.)
 * @property gender Genre (Male, Female)
 * @property description Histoire du personnage
 * @property image URL de l'image
 * @property affiliation Affiliation (Z Fighter, Army of Frieza, etc.)
 * @property deletedAt Date de suppression, null si actif
 */
data class Character(
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

