package com.example.evalmathieud2.home.data.remote.mapper

import com.example.evalmathieud2.home.data.remote.dto.CharacterDto
import com.example.evalmathieud2.home.domain.Character

/**
 * Mapper pour convertir les DTOs de l'API en objets du domaine
 * Transforme CharacterDto (données de l'API) en Character (modèle métier)
 */
object CharacterMapper {

    /**
     * Convertit un CharacterDto en Character
     * @param dto Le DTO provenant de l'API
     * @return L'objet Character du domaine
     */
    fun toCharacter(dto: CharacterDto): Character {
        return Character(
            id = dto.id,
            name = dto.name,
            ki = dto.ki,
            maxKi = dto.maxKi,
            race = dto.race,
            gender = dto.gender,
            description = dto.description,
            image = dto.image,
            affiliation = dto.affiliation,
            deletedAt = dto.deletedAt
        )
    }

    /**
     * Convertit une liste de CharacterDto en liste de Character
     * @param dtos La liste de DTOs provenant de l'API
     * @return La liste d'objets Character du domaine
     */
    fun toCharacterList(dtos: List<CharacterDto>): List<Character> {
        return dtos.map { toCharacter(it) }
    }
}

