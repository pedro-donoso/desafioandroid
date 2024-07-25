package com.desafiolatam.weatherlatam.repository

import com.example.app.model.Item
import com.example.app.util.Result
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class ItemRepositoryImpl : ItemRepository {
    override fun getAllItems(): Flow<Result<List<Item>>> = flow {
        // Implement the logic to retrieve all items
        // For demonstration purposes, let's assume we have a list of items
        val items = listOf(Item("Item 1"), Item("Item 2"))
        emit(Result.Success(items))
    }

    override fun insertItem(item: Item) {
        // Implement the logic to insert an item
    }

    override fun updateItem(item: Item) {
        // Implement the logic to update an item
    }

    override fun deleteItem(item: Item) {
        // Implement the logic to delete an item
    }
}