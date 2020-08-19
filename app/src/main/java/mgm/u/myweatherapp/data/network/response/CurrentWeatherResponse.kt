package mgm.u.myweatherapp.data.network.response

import com.google.gson.annotations.SerializedName
import mgm.u.myweatherapp.data.db.entity.CurrentWeatherEntry
import mgm.u.myweatherapp.data.db.entity.WeatherLocation

data class CurrentWeatherResponse(
    val location: WeatherLocation,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)