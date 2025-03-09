package com.example.desainmu.presentation.feature.result.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.feature.result.ResultState

@Composable
fun ResultDetails(uiState: ResultState, selectedDesign: Design) {
    var selectedTabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("Bagian Depan", "Bagian Belakang")

    Column(modifier = Modifier.padding(16.dp)) {
        TabRow(selectedTabIndex = selectedTabIndex) {
            tabs.forEachIndexed { index, title ->
                Tab(
                    text = { Text(title) },
                    selected = selectedTabIndex == index,
                    onClick = { selectedTabIndex = index }
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        when (selectedDesign) {
            Design.KaosLakiPolaDasar -> {
                when (selectedTabIndex) {
                    0 -> KaosLakiPolaDasarFrontDetails(uiState)
                    1 -> KaosLakiPolaDasarBackDetails(uiState)
                }
            }

            Design.Celana -> {
                Text("Todo")
            }

            Design.KemejaL -> {
                Text("Todo")
            }

            Design.KemejaP -> {
                Text("Todo")
            }

            Design.Rok -> {
                Text("Todo")
            }

            Design.AtasanPerempuan -> {
                Text("Todo")
            }
        }
    }
}

@Composable
fun KaosLakiPolaDasarFrontDetails(uiState: ResultState) {
    Column {
        Text(
            text = "Bagian Depan",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        ResultRow(label = "AF", value = uiState.lineAF)
        ResultRow(label = "AE", value = uiState.lineAE)
        ResultRow(label = "AB/DC", value = uiState.lineABDC.toString())
        ResultRow(label = "AI/DJ", value = uiState.lineAIDJ.toString())
        ResultRow(label = "AL/GH", value = uiState.lineALGH)
        ResultRow(label = "AD/IJ/BC", value = uiState.lineADIJBC.toString())
        ResultRow(label = "AG", value = uiState.lineAG.toString())
        ResultRow(label = "Garis lengkung biru HJ", value = uiState.lineHJ.toString())
    }
}

@Composable
fun KaosLakiPolaDasarBackDetails(uiState: ResultState) {
    Column {
        Text(
            text = "Bagian Belakang",
            style = MaterialTheme.typography.titleMedium,
            fontWeight = FontWeight.Bold
        )
        Spacer(modifier = Modifier.height(8.dp))
        ResultRow(label = "AF", value = uiState.lineAF)
        ResultRow(label = "AK", value = uiState.lineAK)
        ResultRow(label = "AB/DC", value = uiState.lineABDC.toString())
        ResultRow(label = "AI/DJ", value = uiState.lineAIDJ.toString())
        ResultRow(label = "AL/GH", value = uiState.lineALGH)
        ResultRow(label = "AD/IJ/BC", value = uiState.lineADIJBC.toString())
        ResultRow(label = "AG", value = uiState.lineAG.toString())
        ResultRow(label = "Garis lengkung biru HJ", value = uiState.lineHJ.toString())
    }
}

@Composable
fun ResultRow(label: String, value: String) {
    Text(text = "$label = $value cm", style = MaterialTheme.typography.bodyMedium)
}