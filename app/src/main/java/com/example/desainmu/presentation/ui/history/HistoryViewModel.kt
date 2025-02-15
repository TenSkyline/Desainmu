package com.example.desainmu.presentation.ui.history

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class HistoryViewModel: ViewModel() {
    private val _uiState: MutableStateFlow<HistoryState> = MutableStateFlow(
        HistoryState()
    )
    val uiState: StateFlow<HistoryState> get() = _uiState.asStateFlow()

    fun handleEvent(event: HistoryEvent) {
        when (event) {
            is HistoryEvent.SearchItem -> _uiState.update { it.copy(searchQuery = event.query)
            }
            is HistoryEvent.UpdateSearchActive -> _uiState.update { it.copy(isSearchActive = event.isActive) }
        }
    }
}