package com.example.desainmu.presentation.feature.dashboard

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.desainmu.data.database.DesainmuLocalDb
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val database: DesainmuLocalDb
): ViewModel() {
    val uiState get() = _uiState.asStateFlow()
    private val _uiState = MutableStateFlow(DashboardState())

    val uiEffect get() = _uiEffect.asSharedFlow()
    private val _uiEffect = MutableSharedFlow<DashboardEffect>()


    fun handleEvent(event: DashboardEvent) {
        when (event) {
            DashboardEvent.ToAddOrder -> emit(DashboardEffect.ToAddOrder)
            DashboardEvent.ToDelayed -> emit(DashboardEffect.ToDelayedPayment)
            DashboardEvent.ToHistory -> emit(DashboardEffect.ToHistory)

            is DashboardEvent.SelectedTab -> _uiState.update {
                it.copy(selectedTab = event.selectedTab)
            }
        }
    }

    private fun emit(effect: DashboardEffect) = viewModelScope.launch {
        _uiEffect.emit(effect)
    }
}