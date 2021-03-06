package mgm.u.myweatherapp.ui.weather.current

import androidx.lifecycle.ViewModel
import mgm.u.myweatherapp.data.provider.UnitProvider
import mgm.u.myweatherapp.data.repository.ForecastRepository
import mgm.u.myweatherapp.internal.UnitSystem
import mgm.u.myweatherapp.internal.lazyDeferred
import mgm.u.myweatherapp.ui.base.WeatherViewModel

class CurrentWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getCurrentWeather(super.isMetricUnit)
    }
}
