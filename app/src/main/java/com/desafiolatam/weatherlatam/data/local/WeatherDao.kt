package com.desafiolatam.weatherlatam.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow


@Dao
interface WeatherDao {

    // Ejemplo
    @Query("DELETE FROM weather")
    suspend fun clearAll()
}