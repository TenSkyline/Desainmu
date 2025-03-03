package com.example.desainmu.presentation.ui.history

import android.app.Activity
import android.view.inputmethod.InputMethodManager
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton
import com.example.desainmu.presentation.ui.dashboard.components.HistoryItemView
import com.example.desainmu.presentation.ui.dashboard.components.OrderItemModel

@Composable
internal fun HistoryRoute(
    navigateUp: () -> Unit = {},
    dummyValueHistory: List<OrderItemModel>
) {
    val viewModel: HistoryViewModel = viewModel()
    val uiState by viewModel.uiState.collectAsStateWithLifecycle()
    HistoryScreen(onEvent = viewModel::handleEvent, uiState, dummyValueHistory, navigateUp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun HistoryScreen(
    onEvent: (HistoryEvent) -> Unit,
    uiState: HistoryState,
    dummyValueHistory: List<OrderItemModel>,
    navigateUp: () -> Unit
) {
    val filteredList = dummyValueHistory.filter {
        it.title.contains(uiState.searchQuery, ignoreCase = true)
    }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text("Riwayat") },
                navigationIcon = {
                    CustomIconButton(
                        icon = Icons.AutoMirrored.Filled.ArrowBack,
                        onClick = {
                            if (uiState.isSearchActive) {
                                onEvent.invoke(HistoryEvent.UpdateSearchActive(false))
                                onEvent.invoke(HistoryEvent.SearchItem(""))
                            } else {
                                navigateUp.invoke()
                            }
                        }
                    )
                },
                actions = {
                    TextButton(onClick = {
                        onEvent.invoke(HistoryEvent.UpdateSearchActive(!uiState.isSearchActive))
                        if (uiState.isSearchActive) {
                            onEvent.invoke(HistoryEvent.SearchItem(""))
                        }
                    }) {
                        Text(
                            text = if (uiState.isSearchActive) "Tutup" else "Cari",
                            color = Color.Blue
                        )
                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .fillMaxSize()
            ) {
                if (uiState.isSearchActive) {
                    TextField(
                        value = uiState.searchQuery,
                        onValueChange = { onEvent.invoke(HistoryEvent.SearchItem(it)) },
                        modifier = Modifier
                            .fillMaxWidth(),
                        placeholder = { Text("Cari judul pesanan") },
                        trailingIcon = {
                            IconButton(onClick = {
                                // Hide the keyboard when the search icon is clicked
                                focusManager.clearFocus()
                                val imm =
                                    context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                                imm.hideSoftInputFromWindow(
                                    (context as Activity).currentFocus?.windowToken,
                                    0
                                )
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
                                // Hide the keyboard when the "Done" action is triggered
                                focusManager.clearFocus()
                                val imm =
                                    context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                                imm.hideSoftInputFromWindow(
                                    (context as Activity).currentFocus?.windowToken,
                                    0
                                )
                            }
                        )
                    )
                } else {
                    !uiState.isSearchActive
                }
                LazyColumn(
                    contentPadding = PaddingValues(vertical = 24.dp, horizontal = 16.dp),
                    verticalArrangement = Arrangement.spacedBy(16.dp)
                ) {
                    if (filteredList.isNotEmpty()) {
                        items(filteredList) {
                            HistoryItemView(item = it)
                        }

                    } else {
                        item {
                            Text("Data tidak ditemukan")
                        }
                    }
                }
            }
        }
    )
}