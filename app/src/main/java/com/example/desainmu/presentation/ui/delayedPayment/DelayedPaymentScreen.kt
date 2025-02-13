package com.example.desainmu.presentation.ui.delayedPayment

import android.app.Activity
import android.view.View
import android.view.inputmethod.InputMethodManager
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.animation.slideOutVertically
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.core.content.getSystemService
import com.example.desainmu.presentation.common.sharedComponents.CustomIconButton
import com.example.desainmu.presentation.ui.dashboard.components.DelayedItemView
import com.example.desainmu.presentation.ui.dashboard.components.OrderItemModel
import kotlin.text.contains

@Composable
internal fun DelayedPaymentRoute(
    navigateUp: () -> Unit = {},
    dummyValueDelayed: List<OrderItemModel>
) {
    DelayedPaymentScreen(dummyValueDelayed, navigateUp)
}

@Composable
internal fun DelayedPaymentScreen(dummyValueDelayed: List<OrderItemModel>, navigateUp: () -> Unit) {
    DelayedPaymentScaffold(dummyValueDelayed = dummyValueDelayed, navigateUp = navigateUp)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun DelayedPaymentScaffold(
    navigateUp: () -> Unit,
//    onClick: () -> Unit = {},
    dummyValueDelayed: List<OrderItemModel>
) {
    var searchQuery by remember { mutableStateOf("") }
    var isSearchActive by remember { mutableStateOf(false) }
    val filteredList = dummyValueDelayed.filter {
        it.title.contains(searchQuery, ignoreCase = true)
    }
    val focusManager = LocalFocusManager.current
    val context = LocalContext.current

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = { Text("Belum Bayar") },
                navigationIcon = {
                    CustomIconButton(
                        icon = Icons.AutoMirrored.Filled.ArrowBack,
                        onClick = {
                            if (isSearchActive) {
                                isSearchActive = false
                                searchQuery = ""
                            } else {
                                navigateUp.invoke()
                            }
                        }
                    )
                },
                actions = {
                    TextButton(onClick = {
                        isSearchActive = !isSearchActive
                        if (!isSearchActive) {
                            searchQuery = ""
                        }
                    }) {
                        Text(
                            text = if (isSearchActive) "Tutup" else "Cari",
                            color = Color.Blue
                        )
                    }
//                    IconButton(onClick = {
//                        isSearchActive = !isSearchActive
//                        if (!isSearchActive) {
//                            searchQuery = ""
//                        }
//                    }) {
//                        Icon(Icons.Filled.Search, contentDescription = "Search")
//                    }
                }
            )
        },
        content = { innerPadding ->
            Column(
                modifier = Modifier
                    .padding(innerPadding)
                    .padding(16.dp)
                    .verticalScroll(rememberScrollState())
                    .fillMaxSize()
                    .background(Color.Green),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                AnimatedVisibility(
                    visible = isSearchActive,
                    enter = slideInVertically(),
                    exit = slideOutVertically()
                ) {
                    TextField(
                        value = searchQuery,
                        onValueChange = { searchQuery = it },
                        modifier = Modifier
                            .fillMaxWidth(),
                        placeholder = { Text("Cari judul pesanan") },
                        trailingIcon = {
                            IconButton(onClick = {
                                // Hide the keyboard when the search icon is clicked
                                focusManager.clearFocus()
                                val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                                imm.hideSoftInputFromWindow((context as Activity).currentFocus?.windowToken, 0)
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
                                val imm = context.getSystemService(Activity.INPUT_METHOD_SERVICE) as InputMethodManager
                                imm.hideSoftInputFromWindow((context as Activity).currentFocus?.windowToken, 0)
                            }
                        )
                    )
                }
                // Check if there are any delayed items
                if (filteredList.isNotEmpty()) {
                    // Iterate through the list and display each item
                    filteredList.forEach { orderItem ->
                        DelayedItemView(item = orderItem, onClick = {
                            // Handle the click event for this specific item
                            // You can add navigation or other actions here
//                            println("Clicked on item: ${orderItem.title}")
                        })
                    }
                } else {
                    // Handle the case where there are no delayed items
                    // You can display a message or a placeholder here
                    Text("Data tidak ditemukan")
                }
            }
        }
    )
}


//@Composable
//fun DelayedPaymentView() {
//     val delayed = DashboardTab.Delayed
//
//}

