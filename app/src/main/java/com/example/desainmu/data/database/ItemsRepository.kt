package com.example.desainmu.data.database

import androidx.room.Upsert
import com.example.desainmu.model.OrderParam
import com.example.desainmu.presentation.ui.dashboard.components.OrderItemModel
import kotlinx.coroutines.flow.Flow

/**
 * Repository that provides insert, update, delete, and retrieve of [ItemTable] from a given data source.
 */
interface ItemsRepository{
    /**
     * Update/Insert item in the data source
     */
    suspend fun upsertItem(itemTable: OrderParam)
    /**
     * Delete item from the data source
     */
//    suspend fun deleteItem(itemTable: )
    /**
     * Retrieve an item from the given data source that matches with the [id].
     */
//    suspend fun getItem(id: Int): ItemTable?
    /**
     * Retrieve all the items from the the given data source ascending by [daysLeft].
     */
//    fun getItemsByDaysLeft(): Flow<List<OrderItemModel>>

    /**
     * Retrieve all the items from the the given data source ascending by [isDone].
     */
//    fun getItemsByIsDone(): Flow<List<OrderItemModel>>
    /**
     * Retrieve all the items from the the given data source ascending by [isPayed].
     */
//    fun getItemsByIsPayed(): Flow<List<OrderItemModel>>

}