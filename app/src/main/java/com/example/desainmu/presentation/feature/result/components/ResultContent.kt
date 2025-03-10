package com.example.desainmu.presentation.feature.result.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.feature.result.ResultEvent
import com.example.desainmu.presentation.feature.result.ResultState

@Composable
internal fun ResultContent(
    padding: PaddingValues,
    uiState: ResultState,
    selectedDesign: Design,
    onEvent: (ResultEvent) -> Unit) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(padding)
            .padding(16.dp)
    ) {
        item {
            ResultDesignImage(selectedDesign = selectedDesign)
        }
        item {
            ResultDetails(uiState = uiState, selectedDesign = selectedDesign)
        }
        item {
            ElevatedButton(
                onClick = {
                    onEvent.invoke(ResultEvent.SaveItem)
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text("Simpan")
            }
        }
    }
}