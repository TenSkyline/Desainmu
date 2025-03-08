package com.example.desainmu.presentation.common.sharedViewModel

import androidx.lifecycle.ViewModel
import com.example.desainmu.data.database.ItemsRepository

/**
 * ViewModel to validate and insert items in the Room database.
 */
class ItemEntryViewModel(private val itemsRepository: ItemsRepository) : ViewModel() {

}