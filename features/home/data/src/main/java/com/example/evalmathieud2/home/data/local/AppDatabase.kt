package com.example.evalmathieud2.home.data.local

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Base de données Room pour le cache local des personnages.
 */
@Database(
    entities = [CharacterEntity::class],
    version = 1,
    exportSchema = false
)
abstract class AppDatabase : RoomDatabase() {
    abstract fun characterDao(): CharacterDao
}
