package com.example.desainmu.presentation.feature.result

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class ResultViewModel : ViewModel() {
    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(ResultState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<ResultEffect>()

    fun handleEvent(event: ResultEvent) {
        when (event) {
            ResultEvent.NavigateUp -> emit(ResultEffect.NavigateUp)
        }
    }

    private fun emit(effect: ResultEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}
