package com.example.evalmathieud2.home.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Base de données Room de l'application.
 *
 * Contient la table des personnages Dragon Ball pour le cache local.
 * Utilise Room pour gérer la persistance des données de manière efficace.
 *
 * @property characterDao DAO pour accéder aux opérations sur les personnages
 * @see CharacterEntity
 * @see CharacterDao
 */
@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {

    /**
     * Fournit l'accès au DAO des personnages.
     *
     * @return Instance du DAO pour les opérations CRUD sur les personnages
     */
    abstract fun characterDao(): CharacterDao
}

