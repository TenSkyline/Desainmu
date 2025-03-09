package com.example.desainmu.presentation.feature.result

import com.example.desainmu.model.DesignInput


data class ResultState(
    val lineAK: String = "3",
    val lineALGH: String = "4",
    val lineAE: String = "5",
    val lineAF: String = "7",
) {
    val lineABDC: Double get() {
        val resultAB = DesignInput.dataDesign.panjangBaju.toDoubleOrNull() ?: 0.0
        return resultAB
    }
    val lineAIDJ: Double get() {
        val resultAI = DesignInput.dataDesign.lingkarBadan.toDoubleOrNull() ?: 0.0
        return (resultAI / 4) - 2
    }
    val lineADIJBC: Double get() {
        val resultADIJBC = DesignInput.dataDesign.lingkarBadan.toDoubleOrNull() ?: 0.0
        return resultADIJBC / 4
    }
    val lineAG: Double get() {
        val resultAG = DesignInput.dataDesign.panjangSeluruhBahu.toDoubleOrNull() ?: 0.0
        return resultAG / 2
    }
    val lineHJ: Double get() {
        val resultHJ = DesignInput.dataDesign.lingkarBadan.toDoubleOrNull() ?: 0.0
        return resultHJ / 4
    }
}

sealed class ResultEvent {
    data object NavigateUp: ResultEvent()
}

sealed class ResultEffect {
    data object NavigateUp: ResultEffect()
}