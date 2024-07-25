package com.desafiolatam.weatherlatam.data

import com.desafiolatam.weatherlatam.data.local.WeatherEntity
import com.desafiolatam.weatherlatam.model.WeatherDto

// Ejemplo: esta función es una extensión de la clase Weather to, es capaz de tomar una clase DTO y transformarla en Entity
fun WeatherDto.toEntity(): WeatherEntity = WeatherEntity(
    id = id,
    currentTemp = currentTemp,
    maxTemp = maxTemp,
    minTemp = minTemp,
    pressure = pressure,
    humidity = humidity,
    windSpeed = windSpeed,
    sunrise = sunrise,
    sunset = sunset,
    cityName = cityName,
)
