// File: com/desafiolatam/weatherlatam/dao/ItemDao.kt
package com.desafiolatam.weatherlatam.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.desafiolatam.weatherlatam.model.Item
import kotlinx.coroutines.flow.Flow

@Dao
interface ItemDao {
    @Query("SELECT * FROM items")
    fun getAllItems(): Flow<List<Item>>

    @Insert
    fun insertItem(item: Item)

    @Update
    fun updateItem(item: Item)

    @Delete
    fun deleteItem(item: Item)
}