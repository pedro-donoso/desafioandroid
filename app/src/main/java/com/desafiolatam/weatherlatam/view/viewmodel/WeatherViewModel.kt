package com.desafiolatam.weatherlatam.view.viewmodel

import androidx.lifecycle.ViewModel
import com.desafiolatam.weatherlatam.data.WeatherRepositoryImp

class WeatherViewModel(private val repository: WeatherRepositoryImp) : ViewModel() {


    /* Este ejemplo muestra como se puede llamar a la clase repository
    * suspend fun getWeather() = repository.getWeatherData().stateIn(viewModelScope)
    * */
}

