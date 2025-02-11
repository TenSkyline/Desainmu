package com.example.desainmu.presentation.designMeasurement.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.desainmu.model.Design

@Composable
internal fun DesignMeasurementItemView (selectedDesign: Design) {
    when (selectedDesign) {
        Design.Kaos -> {
            MeasurementKaosView()
        }
        Design.Celana -> {
            Text("Celana")
        }
        Design.Kemeja -> {
            // Tambahkan logika untuk desain Kemeja

        }
        Design.Rok -> {
            // Tambahkan logika untuk desain Rok
        }
        Design.AtasanPerempuan -> {

        }
    }
}
