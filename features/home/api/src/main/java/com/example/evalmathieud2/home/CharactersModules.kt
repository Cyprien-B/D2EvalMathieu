package com.example.evalmathieud2.home

import org.koin.dsl.module
import com.example.evalmathieud2.home.data.CharactersRepositoryImpl
import com.example.evalmathieud2.home.domain.CharactersRepository

val charactersModule = module {

    single<CharactersRepository> {
        CharactersRepositoryImpl()
    }
}
