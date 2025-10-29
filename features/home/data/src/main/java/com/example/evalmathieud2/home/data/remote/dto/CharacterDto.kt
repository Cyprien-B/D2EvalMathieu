package com.example.evalmathieud2.home.data.remote.dto

import kotlinx.serialization.Serializable

/**
 * DTO pour un personnage de Dragon Ball
 */
@Serializable
data class CharacterDto(
    val id: Int,
    val name: String,
    val ki: String,
    val maxKi: String,
    val race: String,
    val gender: String,
    val description: String,
    val image: String,
    val affiliation: String,
    val deletedAt: String? = null
)

