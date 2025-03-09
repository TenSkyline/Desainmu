package com.example.desainmu.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.desainmu.data.database.dao.ItemDao
import com.example.desainmu.data.database.model.ItemTable

const val DATABASE_VERSION = 1
const val DATABASE_NAME = "desainmu_db"

@Database(
    entities = [ItemTable::class],
    version = DATABASE_VERSION,
    exportSchema = true
)
abstract class DesainmuLocalDb : RoomDatabase() {
    abstract fun itemDao(): ItemDao
}