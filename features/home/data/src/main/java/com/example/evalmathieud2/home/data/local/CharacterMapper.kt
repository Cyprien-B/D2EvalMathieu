package com.example.evalmathieud2.home.data.local

import com.example.evalmathieud2.home.domain.Character

/** Convertit une entité Room en modèle métier. */
fun CharacterEntity.toDomain(): Character {
    return Character(
        id = id,
        name = name,
        ki = ki,
        maxKi = maxKi,
        race = race,
        gender = gender,
        description = description,
        image = image,
        affiliation = affiliation,
        deletedAt = deletedAt
    )
}

/** Convertit un modèle métier en entité Room. */
fun Character.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = id,
        name = name,
        ki = ki,
        maxKi = maxKi,
        race = race,
        gender = gender,
        description = description,
        image = image,
        affiliation = affiliation,
        deletedAt = deletedAt
    )
}
