package mgm.u.myweatherapp.data.repository

import androidx.lifecycle.LiveData
import mgm.u.myweatherapp.data.db.entity.WeatherLocation
import mgm.u.myweatherapp.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}