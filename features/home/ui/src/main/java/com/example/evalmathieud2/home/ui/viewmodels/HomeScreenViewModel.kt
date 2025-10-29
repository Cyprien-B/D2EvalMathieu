package com.example.evalmathieud2.home.ui.viewmodels


import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.evalmathieud2.home.domain.Character
import com.example.evalmathieud2.home.domain.CharactersRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update

interface CharactersContracts{
    data class UIState (
        val characters: List<Character> = emptyList()
    )
}


class HomeScreenViewModel : ViewModel(), KoinComponent {

    private val repository: CharactersRepository by inject()

    private var _state = MutableStateFlow(CharactersContracts.UIState())

    val state: StateFlow<CharactersContracts.UIState> = _state

    init {
    viewModelScope.launch(Dispatchers.IO) {
        val characters = repository.getCharacters()
        _state.update { it.copy(characters = characters) }
    }
    }
}