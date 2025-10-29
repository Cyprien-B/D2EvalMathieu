package com.example.evalmathieud2.home

import com.example.evalmathieud2.home.data.CharactersRepositoryImpl
import com.example.evalmathieud2.home.data.remote.DragonBallApiClient
import com.example.evalmathieud2.home.domain.CharactersRepository
import org.koin.dsl.module

val charactersModule = module {

    // Instance unique du client API Dragon Ball
    single {
        DragonBallApiClient()
    }

    // Implémentation du repository avec injection du client API
    single<CharactersRepository> {
        CharactersRepositoryImpl(apiClient = get())
    }
}
