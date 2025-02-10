package com.example.desainmu.presentation.addOrderMeasurement.components

import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import com.example.desainmu.model.Design

@Composable
internal fun AddOrderMeasurementItemView (design: Design) {
    when (design) {
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
    }
}