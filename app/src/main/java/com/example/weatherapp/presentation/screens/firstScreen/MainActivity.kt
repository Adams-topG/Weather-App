package com.example.weatherapp.presentation.screens.firstScreen

import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.Navigation
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.databinding.ActivityMainBinding
import com.example.weatherapp.presentation.viewModel.WeatherViewModel
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*

@AndroidEntryPoint
class MainActivity() : AppCompatActivity(R.layout.activity_main) {
    lateinit var navController : NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        navController =Navigation.findNavController(this, R.id.nav_fragment)
//        binding.btnGetWeather.setOnClickListener() {
//            viewModel.getWeather(binding.etCity.text.toString())
//            setObservable()
//        }
//        binding.llToday.setOnClickListener {
//
//        }
    }

//    private fun setObservable() {
//        viewModel.weatherResp.observe(this) {
//            binding.apply {
//                tvTemperature.visibility = View.VISIBLE
//                tvCity.visibility = View.VISIBLE
//                tvWind.visibility = View.VISIBLE
//                llToday.visibility = View.VISIBLE
//                llTomorrow.visibility = View.VISIBLE
//                llThirdDay.visibility = View.VISIBLE
//                tvCity.text = etCity.text
//                tvTemperature.text = "${it.current?.tempC.toString()}°С"
//                tvWind.text = "${it.current?.windKph.toString()}Kph"
//            }
//            setTodayParams(it)
//            setTomorrowParams(it)
//            setThirdParams(it)
//        }
//
//        viewModel.errorResp.observe(this){
//            Toast.makeText(this, it.localizedMessage, Toast.LENGTH_SHORT).show()
//        }
//    }
//
//    private fun setTodayParams(weather: Weather) {
//
//        val url2 = "https://cdn.weatherapi.com/weather/64x64/day/302.png"
//        binding.apply {
//            Glide.with(this@MainActivity)
//                .load("https:${weather.current?.condition?.icon}")
//                .override(100, 100)
//                .into(ivToday)
//            tvDescription.text = weather.current?.condition?.text
//            tvLittleTemp.text =
//                "${weather.forecast?.forecastday?.get(0)?.day?.mintempC.toString()}°/" +
//                        "${weather.forecast?.forecastday?.get(0)?.day?.maxtempC.toString()}°"
//        }
//
//    }
//
//    private fun setTomorrowParams(weather: Weather) {
//        binding.apply {
//            Glide.with(this@MainActivity)
//                .load("https:${weather.forecast?.forecastday?.get(1)?.day?.condition?.icon}")
//                .override(100, 100)
//                .into(ivTomorrow)
//            tvDescriptionTommorrow.text = weather.forecast?.forecastday?.get(1)?.day?.condition?.text
//            tvLittleTempTomorrow.text =
//                "${weather.forecast?.forecastday?.get(1)?.day?.mintempC.toString()}°/" +
//                        "${weather.forecast?.forecastday?.get(1)?.day?.maxtempC.toString()}°"
//        }
//
//    }
//
//    private fun setThirdParams(weather: Weather) {
//        binding.apply {
//            Glide.with(this@MainActivity)
//                .load("https:${weather.forecast?.forecastday?.get(2)?.day?.condition?.icon}")
//                .override(100, 100)
//                .into(ivThirdDay)
//
//            val day = SimpleDateFormat("EE", Locale.ENGLISH).format((weather.forecast?.forecastday?.get(2)?.dateEpoch?.toLong())?.times(
//                1000
//            ) ?: "")
//            tvThirdDay.text = "${day}·"
//            tvThirdDescription.text = weather.forecast?.forecastday?.get(2)?.day?.condition?.text
//            tvThirdTemp.text =
//                "${weather.forecast?.forecastday?.get(2)?.day?.mintempC.toString()}°/" +
//                        "${weather.forecast?.forecastday?.get(2)?.day?.maxtempC.toString()}°"
//        }
//
//    }
}

