package com.example.desainmu.presentation.feature.itemDetail.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.ElevatedButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design
import com.example.desainmu.presentation.design.components.CustomOutlinedTextFieldView
import com.example.desainmu.presentation.feature.itemDetail.ItemDetailEvent
import com.example.desainmu.presentation.feature.itemDetail.ItemDetailState
import java.text.SimpleDateFormat
import java.util.Date
import java.util.Locale

@Composable
internal fun ItemDetailContent(
    innerPadding: PaddingValues,
    uiState: ItemDetailState,
    onEvent: (ItemDetailEvent) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerPadding)
            .padding(16.dp)
    ) {
        item {
            ItemDetailOrderView(
                uiState = uiState
            )
        }
        item {
            ItemDetailSelectedDesignView(uiState = uiState)
        }
//        item {
//            ItemDetailDesignImage()
//        }
//        item {
//            ItemDetailMeasurement()
//        }
        item {
            ElevatedButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Text("Edit")
            }
            ElevatedButton(
                onClick = {},
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(4.dp)
            ) {
                Text("Hapus")
            }
        }
    }
}

@Composable
private fun ItemDetailOrderView(
    uiState: ItemDetailState,
) {
    uiState.item?.let { item ->
        listOf(
            "Judul" to item.title,
            "Deskripsi" to item.description,
            "Tenggat Waktu" to "${formatDate(item.selectedDate)} (${item.daysLeft} hari)",
            "Jenis Desain" to Design.findByName(item.selectedDesign).title
        ).forEach { (placeholder, value) ->
            CustomOutlinedTextFieldView(placeHolder = placeholder, value = value)
        }
    } ?: Text("Item not found") // Optional fallback if item is null
    HorizontalDivider(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        thickness = 1.dp,
        color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
    )
}

@Composable
private fun ItemDetailSelectedDesignView(
    uiState: ItemDetailState
) {
    when (uiState.item.let { it?.let { it1 -> Design.findByName(it1.selectedDesign) } }) {
        Design.KaosLakiPolaDasar -> KaosLakiPolaDasarFields(uiState)
        Design.Celana -> Text("Celana")
        Design.KemejaL -> Text("Kemeja Laki")
        Design.KemejaP -> Text("Kemeja Perempuan")
        Design.Rok -> Text("Rok")
        Design.AtasanPerempuan -> Text("Atasan Perempuan")
        null -> Text("Desain tidak ditemukan")
    }
}

private fun formatDate(longDate: Long?): String {
    if (longDate == null) return "-"
    val sdf = SimpleDateFormat("EEEE, dd MMMM yyyy", Locale.getDefault())
    return sdf.format(Date(longDate))
}