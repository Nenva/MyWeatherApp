package mgm.u.myweatherapp.data.network.response

import com.google.gson.annotations.SerializedName
import mgm.u.myweatherapp.data.db.entity.WeatherLocation

data class FutureWeatherResponse(
    @SerializedName("forecast")
    val futureWeatherEntries: ForecastDaysContainer,
    val location: WeatherLocation
)