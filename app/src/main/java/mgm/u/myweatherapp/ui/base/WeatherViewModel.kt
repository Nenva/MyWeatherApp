package mgm.u.myweatherapp.ui.base

import androidx.lifecycle.ViewModel
import mgm.u.myweatherapp.data.provider.UnitProvider
import mgm.u.myweatherapp.data.repository.ForecastRepository
import mgm.u.myweatherapp.internal.UnitSystem
import mgm.u.myweatherapp.internal.lazyDeferred

open class WeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : ViewModel() {
    private val unitSystem = unitProvider.getUnitSystem()

    val isMetricUnit: Boolean get() = unitSystem == UnitSystem.METRIC

    val weatherLocation by lazyDeferred {
        forecastRepository.getWeatherLocation()
    }

}