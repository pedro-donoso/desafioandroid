// File: com/desafiolatam/weatherlatam/util/Result.kt
package com.desafiolatam.weatherlatam.util

sealed class Result<out T> {
    data class Success<out T>(val data: T) : Result<T>()
    data class Error(val exception: Exception) : Result<Nothing>()
}