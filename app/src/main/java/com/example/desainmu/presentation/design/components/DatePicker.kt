package com.example.desainmu.presentation.design.components

import androidx.compose.foundation.gestures.awaitEachGesture
import androidx.compose.foundation.gestures.awaitFirstDown
import androidx.compose.foundation.gestures.waitForUpOrCancellation
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.DatePickerState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.pointer.PointerEventPass
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.R
import com.example.desainmu.presentation.feature.addOrder.AddOrderEvent
import com.example.desainmu.presentation.feature.addOrder.AddOrderViewModel
import java.text.SimpleDateFormat
import java.time.Instant
import java.time.ZoneId
import java.util.Calendar
import java.util.Locale

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerFieldToModal(modifier: Modifier = Modifier, viewModel: AddOrderViewModel = viewModel()) {
    val uiState by viewModel.uiState.collectAsState()
    var showDatePicker by remember { mutableStateOf(false) }
    val datePickerState = rememberDatePickerState(initialSelectedDateMillis = uiState.selectedDate)

    OutlinedTextField(
        value = convertMillisToDate(uiState.selectedDate),
        onValueChange = { },
        label = { Text(stringResource(R.string.due_date)) },
        placeholder = { Text(stringResource(R.string.date_format)) },
        trailingIcon = {
            Icon(Icons.Default.DateRange, contentDescription = stringResource(R.string.select_date))
        },
        modifier = modifier
            .fillMaxWidth()
            .pointerInput(datePickerState.selectedDateMillis) {
                awaitEachGesture {
                    awaitFirstDown(pass = PointerEventPass.Initial)
                    val upEvent = waitForUpOrCancellation(pass = PointerEventPass.Initial)
                    if (upEvent != null) {
                        showDatePicker = true
                    }
                }
            }
    )

    if (showDatePicker) {
        DatePickerModal(
            viewModel = viewModel,
            datePickerState = datePickerState,
            onDismiss = { showDatePicker = false }
        )
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DatePickerModal(
    viewModel: AddOrderViewModel = viewModel(),
    datePickerState: DatePickerState,
    onDismiss: () -> Unit,
) {
    DatePickerDialog(
        onDismissRequest = { onDismiss() },
        confirmButton = {
            TextButton(onClick = {
                datePickerState.selectedDateMillis?.let {
                    viewModel.handleEvent(AddOrderEvent.SetSelectedDate(it)) // Save as Long
                }
                onDismiss()
            }) {
                Text("Simpan")
            }
        },
        dismissButton = {
            TextButton(onClick = onDismiss) {
                Text("Batal")
            }
        }
    ) {
        DatePicker(
            state = datePickerState,
            title = null,
            headline = null,
            showModeToggle = false,
            modifier = Modifier,
        )
    }
}

fun convertMillisToDate(millis: Long): String {
    val calendar = Calendar.getInstance().apply { timeInMillis = millis }
    val locale = Locale.getDefault()
    val formatter = if (locale.language == "in") {
        SimpleDateFormat("EEEE, dd MMMM yyyy", locale)
    } else {
        SimpleDateFormat("MMMM dd, yyyy", locale)
    }
    return formatter.format(calendar.time)
}


