package com.example.evalmathieud2.home.data.remote.dto

import kotlinx.serialization.Serializable

/**
 * DTO pour la réponse complète de l'API des personnages
 */
@Serializable
data class CharactersResponseDto(
    val items: List<CharacterDto>,
    val meta: MetaDto,
    val links: LinksDto
)

