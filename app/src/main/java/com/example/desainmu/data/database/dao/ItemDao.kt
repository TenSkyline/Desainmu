package com.example.desainmu.data.database.dao

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Upsert
import com.example.desainmu.data.database.model.ItemTable
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {

    @Upsert
    suspend fun upsertItem(itemTable: ItemTable)

    @Query("DELETE FROM items WHERE id = :itemId")
    suspend fun deleteById(itemId: Int)

    //Find item based on id
    @Query("SELECT * from items WHERE id = :id")
    fun getItemById(id: Int): ItemTable

    //Update isDone
    @Query("UPDATE items SET isDone = :isDone WHERE id = :id")
    suspend fun updateIsDone(id: Int, isDone: Boolean)

    //Update isPayed
    @Query("UPDATE items SET isPayed = :isPayed WHERE id = :id")
    suspend fun updateIsPayed(id: Int, isPayed: Boolean)

    //Update dateDone
    @Query("UPDATE items SET dateDone = :dateDone WHERE id = :id")
    suspend fun updateDateDone(id: Int, dateDone: Long)

    //Update datePayed
    @Query("UPDATE items SET datePayed = :datePayed WHERE id = :id")
    suspend fun updateDatePayed(id: Int, datePayed: Long)

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