package com.example.evalmathieud2.home.data.remote.dto

import kotlinx.serialization.Serializable

/**
 * DTO pour les métadonnées de pagination
 */
@Serializable
data class MetaDto(
    val totalItems: Int,
    val itemCount: Int,
    val itemsPerPage: Int,
    val totalPages: Int,
    val currentPage: Int
)

