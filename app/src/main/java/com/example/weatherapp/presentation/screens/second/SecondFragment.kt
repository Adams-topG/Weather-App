package com.example.weatherapp.presentation.screens.second

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Current
import com.example.weatherapp.data.model.Forecastday
import com.example.weatherapp.databinding.FragmentSecondBinding
import com.example.weatherapp.presentation.adapter.ItemAdapter
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class SecondFragment : Fragment(R.layout.fragment_second) {
    private val args: SecondFragmentArgs by navArgs()
    private val binding: FragmentSecondBinding by viewBinding(FragmentSecondBinding::bind)
    private var adapter: ItemAdapter? = null

    @Inject
    lateinit var gson: Gson

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val arg = args.day
        val arg2 = args.current
        val current = gson.fromJson(arg2, Current::class.java)
        val day = gson.fromJson(arg, Forecastday::class.java)
        adapter = ItemAdapter(day)
        binding.rvItems.adapter = adapter
        binding.apply {
            tvSunrise.text = day.astro?.sunrise
            tvSunset.text = day.astro?.sunset
            tvAvgTemp.text = "${day?.day?.avgtempC.toString()}°C"
            tvChanceRain.text = "${day.day?.dailyChanceOfRain.toString()}%"
            tvMaxWind.text = "${day.day?.maxwindKph.toString()}km/h"
            tvHumidity.text = "${day.day?.avghumidity.toString()}%"
            tvPrecip.text = "${day.day?.totalprecipMm}mmHg"
            tvUvIndex.text = day.day?.uv.toString()
        }

    }


}