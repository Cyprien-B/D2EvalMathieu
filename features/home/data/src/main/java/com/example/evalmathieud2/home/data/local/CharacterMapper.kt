package com.example.evalmathieud2.home.data.local

import com.example.evalmathieud2.home.domain.Character

/**
 * Convertit une entité Room en modèle métier.
 *
 * Transforme un [CharacterEntity] de la base de données locale
 * en un objet [Character] du domaine métier.
 *
 * @receiver CharacterEntity à convertir
 * @return Character correspondant au modèle métier
 * @see CharacterEntity
 * @see Character
 */
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

/**
 * Convertit un modèle métier en entité Room.
 *
 * Transforme un objet [Character] du domaine métier
 * en un [CharacterEntity] pour la base de données locale.
 *
 * @receiver Character à convertir
 * @return CharacterEntity correspondant à l'entité de base de données
 * @see Character
 * @see CharacterEntity
 */
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

