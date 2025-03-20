package com.example.desainmu.presentation.feature.itemDetail.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.presentation.design.components.CustomOutlinedTextFieldView
import com.example.desainmu.presentation.feature.itemDetail.ItemDetailState

@Composable
internal fun KaosLakiPolaDasarFields(uiState: ItemDetailState) {
    Row(
        modifier = Modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Column(
            modifier = Modifier.weight(1f)
        ) {
            CustomOutlinedTextFieldView(
                modifier = Modifier.fillMaxWidth(),
                placeHolder = "Lingkar Badan",
                value = uiState.item?.lingkarBadan.toString()
            )
            CustomOutlinedTextFieldView(
                modifier = Modifier.fillMaxWidth(),
                placeHolder = "Panjang Seluruh Bahu",
                value = uiState.item?.panjangSeluruhBahu.toString()
            )
            CustomOutlinedTextFieldView(
                modifier = Modifier.fillMaxWidth(),
                placeHolder = "Panjang Baju",
                value = uiState.item?.panjangBaju.toString()
            )
        }

        // Right Column for sleeve measurements
        Column(
            modifier = Modifier.weight(1f)
        ) {
            CustomOutlinedTextFieldView(
                modifier = Modifier.fillMaxWidth(),
                placeHolder = "Panjang Lengan",
                value = uiState.item?.panjangLengan.toString()
            )
            CustomOutlinedTextFieldView(
                modifier = Modifier.fillMaxWidth(),
                placeHolder = "Lebar Lengan",
                value = uiState.item?.lebarLengan.toString()
            )
        }
    }
}