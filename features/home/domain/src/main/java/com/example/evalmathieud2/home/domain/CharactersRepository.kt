package com.example.evalmathieud2.home.domain

interface CharactersRepository {
    suspend fun getCharacters(): List<Character>
}
