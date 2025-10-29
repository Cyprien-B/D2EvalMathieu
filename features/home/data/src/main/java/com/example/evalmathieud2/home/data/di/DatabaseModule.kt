package com.example.evalmathieud2.home.data.di

import android.content.Context
import androidx.room.Room
import com.example.evalmathieud2.home.data.local.AppDatabase
import com.example.evalmathieud2.home.data.local.CharacterDao
import org.koin.dsl.module

/**
 * Module Koin pour l'injection de dépendances de la couche de données.
 *
 * Fournit la base de données Room et le DAO des personnages.
 *
 * @see AppDatabase
 * @see CharacterDao
 */
val databaseModule = module {

    /**
     * Fournit une instance singleton de la base de données Room.
     *
     * La base de données est créée avec le nom "dragonball_database".
     */
    single {
        Room.databaseBuilder(
            get<Context>(),
            AppDatabase::class.java,
            "dragonball_database"
        )
        .fallbackToDestructiveMigration() // En cas de changement de schéma, recrée la DB
        .build()
    }

    /**
     * Fournit le DAO des personnages depuis la base de données.
     */
    single<CharacterDao> {
        get<AppDatabase>().characterDao()
    }
}

