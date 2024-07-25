// File: com/desafiolatam/weatherlatam/repository/ItemRepository.kt
package com.desafiolatam.weatherlatam.repository

import com.example.app.model.Item
import com.desafiolatam.weatherlatam.util.Result
import kotlinx.coroutines.flow.Flow

interface ItemRepository {
    fun getAllItems(): Flow<Result<List<Item>>>
    fun insertItem(item: Item)
    fun updateItem(item: Item)
    fun deleteItem(item: Item)
}