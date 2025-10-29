package com.example.evalmathieud2.home.data.remote.dto

import kotlinx.serialization.Serializable

/**
 * DTO pour les liens de pagination
 */
@Serializable
data class LinksDto(
    val first: String,
    val previous: String,
    val next: String,
    val last: String
)

