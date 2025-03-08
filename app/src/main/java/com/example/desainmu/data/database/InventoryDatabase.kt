package com.example.desainmu.data.database

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * Database class with a singleton Instance object.
 */
@Database(
    entities = [ItemTable::class],
    version = 1,
    exportSchema = false
)
abstract class InventoryDatabase : RoomDatabase() {

    abstract val dao: ItemDao
}