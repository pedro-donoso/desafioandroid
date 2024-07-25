package com.desafiolatam.weatherlatam.view.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.desafiolatam.weatherlatam.databinding.ItemWeatherBinding
import com.desafiolatam.weatherlatam.extension.toFahrenheit
import com.desafiolatam.weatherlatam.model.WeatherDto

class WeatherAdapter(
    var weatherList: List<WeatherDto>,
    var inCelsius: Boolean,
) : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    lateinit var binding: ItemWeatherBinding

    var onClick: ((Int) -> Unit)? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WeatherViewHolder {
        val itemBinding =
            ItemWeatherBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return WeatherViewHolder(itemBinding)
    }

    override fun onBindViewHolder(holder: WeatherViewHolder, position: Int) =
        holder.onBind(weatherList[position])

    override fun getItemCount(): Int = weatherList.size

    inner class WeatherViewHolder(private val itemBinding: ItemWeatherBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {
        fun onBind(weatherDto: WeatherDto) {
            itemBinding.currentTemp.text =
                if (inCelsius) weatherDto.currentTemp.toString()
                else weatherDto.currentTemp.toFahrenheit().toString()
            itemBinding.maximumTemp.text =
                if (inCelsius) weatherDto.maxTemp.toString()
                else weatherDto.maxTemp.toFahrenheit().toString()
            itemBinding.minimumTemp.text =
                if (inCelsius) weatherDto.minTemp.toString()
                else weatherDto.minTemp.toFahrenheit().toString()
            itemBinding.root.setOnClickListener {
                onClick?.invoke(weatherDto.id)
            }
        }
    }
}