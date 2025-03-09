package com.example.desainmu.data.database.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Query
import androidx.room.Upsert
import com.example.desainmu.data.database.model.ItemTable
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Upsert
    suspend fun upsertItem(itemTable: ItemTable)

    @Delete
    suspend fun delete(itemTable: ItemTable)

    //Find item based on id
    @Query("SELECT * from items WHERE id = :id")
    fun getItems(id: Int): ItemTable

    //Sort item based on title
//    @Query("SELECT * from items ORDER BY title ASC")
//    fun getItemsByTitle(): Flow<List<Item>>

    //Sort item based on days left (for dashboard order tab)
    @Query("SELECT * FROM items WHERE isDone = 0 AND isPayed = 0 ORDER BY daysLeft ASC")
    fun getItemsByDaysLeft(): Flow<List<ItemTable>>

    //Sort item based on date done (for dashboard delayed tab)
    @Query("SELECT * from items WHERE isDone = 1 AND isPayed = 0 ORDER BY dateDone ASC")
    fun getItemsByIsDone(): Flow<List<ItemTable>>

    //Sort item based on date payed (for dashboard history tab)
    @Query("SELECT * from items WHERE isDone = 1 AND isPayed = 1 ORDER BY datePayed ASC")
    fun getItemsByIsPayed(): Flow<List<ItemTable>>
}