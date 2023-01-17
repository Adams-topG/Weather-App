package com.example.weatherapp.presentation.screens.firstScreen

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Forecast
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.databinding.FragmentStartBinding
import com.example.weatherapp.presentation.viewModel.WeatherViewModel
import com.example.weatherapp.utils.keyboard.hideKeyboard
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import java.text.SimpleDateFormat
import java.util.*
import javax.inject.Inject

@AndroidEntryPoint
class StartFragment : Fragment(R.layout.fragment_start) {
    private val binding: FragmentStartBinding by viewBinding(FragmentStartBinding::bind)
    private val viewModel: WeatherViewModel by viewModels()
    private var model: Forecast? = null
    private var weather: Weather? = null
    @Inject
    lateinit var gson : Gson
    override fun onStart() {
        super.onStart()
        viewModel.getWeather(binding.etCity.text.toString())
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setObservable()
        binding.btnGetWeather.setOnClickListener {
            viewModel.getWeather(binding.etCity.text.toString())
            hideKeyboard()
        }
        binding.llToday.setOnClickListener {

            val a = model?.forecastday?.get(0)
            val current = weather?.current
            val json = gson.toJson(a)
            val currentJson = gson.toJson(current)
            findNavController().navigate(
                StartFragmentDirections.actionStartFragmentToSecondFragment(
                    json,
                    0,
                    currentJson
                )
            )

        }
        binding.llTomorrow.setOnClickListener {
            val b = model?.forecastday?.get(1)
            val current = weather?.current
            val json = gson.toJson(b)
            val currentJson = gson.toJson(current)
            findNavController().navigate(
                StartFragmentDirections.actionStartFragmentToSecondFragment(
                    json,
                    1,
                    currentJson
                )
            )

        }
        binding.llThirdDay.setOnClickListener {
            val c = model?.forecastday?.get(2)
            val current = weather?.current
            val json = gson.toJson(c)
            val currentJson = gson.toJson(current)
            findNavController().navigate(
                StartFragmentDirections.actionStartFragmentToSecondFragment(
                    json,
                    2,
                    currentJson
                )
            )

        }
    }

    private fun setObservable() {
        viewModel.weatherResp.observe(viewLifecycleOwner) {
            model = it.forecast
            weather = it
            binding.apply {
                tvTemperature.visibility = View.VISIBLE
                tvCity.visibility = View.VISIBLE
                tvWind.visibility = View.VISIBLE
                llToday.visibility = View.VISIBLE
                llTomorrow.visibility = View.VISIBLE
                llThirdDay.visibility = View.VISIBLE
                tvCity.text = etCity.text
                tvTemperature.text = "${it.current?.tempC.toString()}°С"
                tvWind.text = "${it.current?.windKph.toString()}Kph"
            }
            setTodayParams(it)
            setTomorrowParams(it)
            setThirdParams(it)
        }
    }

    private fun setTodayParams(weather: Weather) {
        binding.apply {
            Glide.with(this@StartFragment)
                .load("https:${weather.current?.condition?.icon}")
                .override(100, 100)
                .into(ivToday)
            tvDescription.text = weather.current?.condition?.text
            tvLittleTemp.text =
                "${weather.forecast?.forecastday?.get(0)?.day?.mintempC.toString()}°/" +
                        "${weather.forecast?.forecastday?.get(0)?.day?.maxtempC.toString()}°"
        }
    }

    private fun setTomorrowParams(weather: Weather) {
        binding.apply {
            Glide.with(this@StartFragment)
                .load("https:${weather.forecast?.forecastday?.get(1)?.day?.condition?.icon}")
                .override(100, 100)
                .into(ivTomorrow)
            tvDescriptionTommorrow.text =
                weather.forecast?.forecastday?.get(1)?.day?.condition?.text
            tvLittleTempTomorrow.text =
                "${weather.forecast?.forecastday?.get(1)?.day?.mintempC.toString()}°/" +
                        "${weather.forecast?.forecastday?.get(1)?.day?.maxtempC.toString()}°"
        }

    }

    private fun setThirdParams(weather: Weather) {
        binding.apply {
            Glide.with(this@StartFragment)
                .load("https:${weather.forecast?.forecastday?.get(2)?.day?.condition?.icon}")
                .override(100, 100)
                .into(ivThirdDay)
            val day = SimpleDateFormat("EE", Locale.ENGLISH).format(
                (weather.forecast?.forecastday?.get(2)?.dateEpoch?.toLong())?.times(
                    1000
                ) ?: ""
            )
            tvThirdDay.text = "${day}·"
            tvThirdDescription.text = weather.forecast?.forecastday?.get(2)?.day?.condition?.text
            tvThirdTemp.text =
                "${weather.forecast?.forecastday?.get(2)?.day?.mintempC.toString()}°/" +
                        "${weather.forecast?.forecastday?.get(2)?.day?.maxtempC.toString()}°"
        }
    }


}


