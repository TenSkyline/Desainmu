//package com.example.desainmu.data.database.datasource.base
//
//import com.example.desainmu.data.database.dao.ItemDao
//import com.example.desainmu.data.database.model.ItemTable
//import com.example.desainmu.notused.ItemsRepository
//
////Kalau class yg ada di dalam kurung nnamanya dependency injection, kalau di dalam function parameter
////ItemRepository adalah blueprint
//abstract class LocalDataSource(private val itemDao: ItemDao) : ItemsRepository {
//
//    suspend fun save(itemTable: ItemTable) = itemDao.upsertItem(itemTable)
//
////    override suspend fun deleteItem(itemTable: ItemTable) = itemDao.delete(itemTable)
////
////    override suspend fun getItem(id: Int): ItemTable = itemDao.getItems(id)
////
////    override fun getItemsByDaysLeft(): Flow<List<OrderItemModel>> = itemDao.getItemsByDaysLeft()
////
////    override fun getItemsByIsDone(): Flow<List<ItemTable>> = itemDao.getItemsByIsDone()
////
////    override fun getItemsByIsPayed(): Flow<List<ItemTable>> = itemDao.getItemsByIsPayed()
//}