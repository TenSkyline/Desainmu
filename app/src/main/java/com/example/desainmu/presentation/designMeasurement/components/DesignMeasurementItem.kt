package com.example.desainmu.presentation.designMeasurement.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
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