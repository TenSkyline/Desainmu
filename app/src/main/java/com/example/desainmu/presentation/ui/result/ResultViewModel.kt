package com.example.desainmu.presentation.ui.result

import androidx.compose.animation.core.copy
import androidx.lifecycle.ViewModel
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementEvent
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class ResultViewModel : ViewModel() {
    private val _uiState : MutableStateFlow<ResultState> = MutableStateFlow(ResultState())

    val uiState: StateFlow<ResultState> get() = _uiState.asStateFlow()

    fun handleEvent(event: ResultEvent) {
        when (event) {
            is ResultEvent.LingkarBadan -> _uiState.update {
                it.copy(lingkarBadan = event.lingkarBadan)
            }
            is ResultEvent.PanjangBaju -> _uiState.update {
                it.copy(panjangBaju = event.panjangBaju)
            }
            is ResultEvent.PanjangSeluruhBahu -> _uiState.update {
                it.copy(panjangSeluruhBahu = event.panjangSeluruhBahu)
            }
        }
    }
}