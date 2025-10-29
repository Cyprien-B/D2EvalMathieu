package com.example.evalmathieud2.home

import com.example.evalmathieud2.home.data.CharactersRepositoryImpl
import com.example.evalmathieud2.home.data.di.databaseModule
import com.example.evalmathieud2.home.data.remote.DragonBallApiClient
import com.example.evalmathieud2.home.domain.CharactersRepository
import org.koin.dsl.module

val charactersModule = module {

    // Inclut le module de base de données (AppDatabase + CharacterDao)
    includes(databaseModule)

    // Client API Dragon Ball
    single {
        DragonBallApiClient()
    }

    // Repository avec injection du client API et du DAO Room
    single<CharactersRepository> {
        CharactersRepositoryImpl(apiClient = get(), characterDao = get())
    }
}
