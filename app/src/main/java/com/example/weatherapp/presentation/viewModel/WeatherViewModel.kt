package com.example.weatherapp.presentation.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.weatherapp.data.model.Weather
import com.example.weatherapp.data.repository.WeatherRepository
import com.example.weatherapp.databinding.ActivityMainBinding
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class WeatherViewModel
@Inject
constructor(private val repository: WeatherRepository) : ViewModel() {

    private val _resp = MutableLiveData<Weather>()
    val weatherResp: LiveData<Weather>
        get() = _resp

    private val _error = MutableLiveData<Throwable>()
    val errorResp: LiveData<Throwable>
        get() = _error

    fun getWeather(city: String) = viewModelScope.launch {
        repository.getWeather(city)
            .onSuccess {
                if (it != null) {
                    _resp.postValue(it)
                }
            }.onFailure {
                _error.postValue(it)
            }
    }
}