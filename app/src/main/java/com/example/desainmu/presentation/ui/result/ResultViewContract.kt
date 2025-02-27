package com.example.desainmu.presentation.ui.result

import com.example.desainmu.model.DesignInput


data class ResultState(
    val lineAF: String = "7",
    val lineAK: String = "3",
    val lineALGH: String = "4",
    val lineAE: String = "5",
) {
    val lineABDC: String get() {
        val resultAB = DesignInput.data.panjangBaju
        return resultAB
    }
    val lineAIDJ: Double get() {
        val resultAI = DesignInput.data.lingkarBadan.toDoubleOrNull() ?: 0.0
        return (resultAI / 4) - 2
    }
    val lineADIJBC: Double get() {
        val resultADIJBC = DesignInput.data.lingkarBadan.toDoubleOrNull() ?: 0.0
        return resultADIJBC / 4
    }
    val lineFG: Double get() {
        val resultFG = DesignInput.data.panjangSeluruhBahu.toDoubleOrNull() ?: 0.0
        return resultFG
    }
    val lineQP: Double get() {
        val resultQP = DesignInput.data.panjangBaju.toDoubleOrNull() ?: 0.0
        return resultQP
    }
}

sealed class ResultEvent {
    // ... other events
}