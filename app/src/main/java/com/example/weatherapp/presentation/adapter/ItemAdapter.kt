package com.example.weatherapp.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.weatherapp.R
import com.example.weatherapp.data.model.Day
import com.example.weatherapp.data.model.Forecastday
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.databinding.RvItemBinding
import java.text.SimpleDateFormat
import java.util.*

class ItemAdapter(var fcDay: Forecastday): RecyclerView.Adapter<ItemAdapter.ItemViewHolder>(){

    class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val binding =RvItemBinding.bind(view)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view =LayoutInflater.from(parent.context).inflate(R.layout.rv_item, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val listPosition = fcDay.hour?.get(position)
        val rightNow = Calendar.getInstance()
        val currentHourIn24Format: Int =rightNow.get(Calendar.HOUR_OF_DAY)
        val formatter = SimpleDateFormat("h:mm a")
        val formatter2 = SimpleDateFormat("yyyy-MM-dd HH:mm")
        val date = formatter2.parse(listPosition?.time)
        with(holder){
            binding.tvTimeItem.text = formatter.format(date)
            binding.tvItemTemperature.text = listPosition?.tempC.toString()
            Glide.with(itemView)
                .load("https:${listPosition?.condition?.icon}")
                .override(100, 100)
                .into(binding.ivItemPhase)
            binding.tvItemWind.text = "${listPosition?.windKph.toString()}Km/h"
            binding.tvItemWindDir.text = listPosition?.windDir.toString()
        }


    }

    override fun getItemCount(): Int {
       return fcDay.hour?.size?: 0
    }


}