package com.example.desainmu.presentation.ui.result

import com.example.desainmu.model.DesignInput
import com.example.desainmu.presentation.ui.designMeasurement.DesignMeasurementViewModel



data class ResultState(
    val garisIJ: String = "",
    val lingkarBadan: String = ""
) {
    val resultIJ: Double get() {
        val resultIJValue = DesignInput.data.lingkarBadan.toDoubleOrNull() ?: 0.0
        return resultIJValue / 2
    }
}

sealed class ResultEvent {
    data class LingkarBadan(val lingkarBadan: String) : ResultEvent()
    // ... other events
}