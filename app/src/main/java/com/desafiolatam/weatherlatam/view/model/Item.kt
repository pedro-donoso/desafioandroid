package com.example.app.weather.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.flow
import com.desafiolatam.weatherlatam.repository.ItemRepository
import com.example.app.repository.ItemRepository
import com.example.app.model.Item
import com.example.app.util.Result

class WeatherViewModel(private val itemRepository: ItemRepository) : ViewModel() {

    fun getAllItems(): Flow<Result<List<Item>>> {
        return itemRepository.getAllItems().map { Result.Success(it) }
            .catch { emit(Result.Error(it)) }
    }

    fun insertItem(item: Item) {
        itemRepository.insertItem(item)
    }

    fun updateItem(item: Item) {
        itemRepository.updateItem(item)
    }

    fun deleteItem(item: Item) {
        itemRepository.deleteItem(item)
    }
}

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}