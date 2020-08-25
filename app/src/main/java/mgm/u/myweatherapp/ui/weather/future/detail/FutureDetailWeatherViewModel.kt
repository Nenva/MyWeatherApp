package mgm.u.myweatherapp.ui.weather.future.detail

import androidx.lifecycle.ViewModel
import mgm.u.myweatherapp.data.provider.UnitProvider
import mgm.u.myweatherapp.data.repository.ForecastRepository
import mgm.u.myweatherapp.internal.lazyDeferred
import mgm.u.myweatherapp.ui.base.WeatherViewModel
import org.threeten.bp.LocalDate

class FutureDetailWeatherViewModel(
    private val detailDate: LocalDate,
    private val forecastRepository: ForecastRepository,
    unitProvider: UnitProvider
) : WeatherViewModel(forecastRepository, unitProvider) {

    val weather by lazyDeferred {
        forecastRepository.getFutureWeatherByDate(detailDate, super.isMetricUnit)
    }
}