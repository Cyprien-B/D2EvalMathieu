package com.example.evalmathieud2.home.data.di

import android.content.Context
import androidx.room.Room
import com.example.evalmathieud2.home.data.local.AppDatabase
import com.example.evalmathieud2.home.data.local.CharacterDao
import org.koin.dsl.module

/**
 * Module Koin pour la base de données Room.
 */
val databaseModule = module {

    /** Instance unique de la base de données Room. */
    single {
        Room.databaseBuilder(
            get<Context>(),
            AppDatabase::class.java,
            "dragonball_database"
        )
        .fallbackToDestructiveMigration()
        .build()
    }

    /** Fournit le DAO des personnages. */
    single<CharacterDao> {
        get<AppDatabase>().characterDao()
    }
}
