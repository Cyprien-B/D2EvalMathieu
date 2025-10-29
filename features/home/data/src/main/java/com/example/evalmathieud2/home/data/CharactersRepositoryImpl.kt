package com.example.evalmathieud2.home.data

import com.example.evalmathieud2.home.data.mock.MockData
import com.example.evalmathieud2.home.domain.Character
import com.example.evalmathieud2.home.domain.CharactersRepository

/**
 * implementation de
 */
class CharactersRepositoryImpl : CharactersRepository {

    override suspend fun getCharacters(): List<Character> {
        return MockData.characters
    }
}