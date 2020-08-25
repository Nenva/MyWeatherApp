package mgm.u.myweatherapp.data.repository

import androidx.lifecycle.LiveData
import mgm.u.myweatherapp.data.db.entity.WeatherLocation
import mgm.u.myweatherapp.data.db.unitlocalized.current.UnitSpecificCurrentWeatherEntry
import mgm.u.myweatherapp.data.db.unitlocalized.future.detail.UnitSpecificDetailFutureWeatherEntry
import mgm.u.myweatherapp.data.db.unitlocalized.future.list.UnitSpecificSimpleFutureWeatherEntry
import org.threeten.bp.LocalDate

interface ForecastRepository {
    suspend fun getCurrentWeather(metric: Boolean): LiveData<out UnitSpecificCurrentWeatherEntry>
    suspend fun getFutureWeatherList(startDate: LocalDate, metric: Boolean): LiveData<out List<UnitSpecificSimpleFutureWeatherEntry>>
    suspend fun getFutureWeatherByDate(date: LocalDate, metric: Boolean): LiveData<out UnitSpecificDetailFutureWeatherEntry>
    suspend fun getWeatherLocation(): LiveData<WeatherLocation>
}