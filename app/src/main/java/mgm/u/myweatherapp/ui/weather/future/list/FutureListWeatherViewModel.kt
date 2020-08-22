package mgm.u.myweatherapp.ui.weather.future.list

import androidx.lifecycle.ViewModel
import mgm.u.myweatherapp.data.provider.UnitProvider
import mgm.u.myweatherapp.data.repository.ForecastRepository
import mgm.u.myweatherapp.internal.lazyDeferred
import mgm.u.myweatherapp.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureListWeatherViewModel(
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weatherEntries by lazyDeferred {
        forecastRepository.getFutureWeatherList(LocalDate.now(), super.isMetricUnit)
    }
}