package com.example.desainmu.presentation.ui.delayedPayment.components

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType

@Composable
fun DelayedPaymentSearchTextField(
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
    focusManager: androidx.compose.ui.focus.FocusManager,
    context: android.content.Context
) {
    TextField(
        value = searchQuery,
        onValueChange = onSearchQueryChanged,
        modifier = Modifier.fillMaxWidth(),
        placeholder = { Text("Cari judul pesanan") },
        trailingIcon = {
            IconButton(onClick = {
                focusManager.clearFocus()
                hideKeyboard(context)
            }) {
                Icon(Icons.Filled.Search, contentDescription = "Search")
            }
        },
        keyboardOptions = KeyboardOptions(
            imeAction = ImeAction.Done,
            keyboardType = KeyboardType.Text
        ),
        keyboardActions = KeyboardActions(
            onDone = {
                focusManager.clearFocus()
                hideKeyboard(context)
            }
        )
    )
}

private fun hideKeyboard(context: android.content.Context) {
    val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
    imm.hideSoftInputFromWindow((context as Activity).currentFocus?.windowToken, 0)
}
