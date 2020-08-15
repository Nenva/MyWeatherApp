package mgm.u.myweatherapp.data.network.response

import com.google.gson.annotations.SerializedName
import mgm.u.myweatherapp.data.db.entity.CurrentWeatherEntry
import mgm.u.myweatherapp.data.db.entity.Location

data class CurrentWeatherResponse(
    val location: Location,
    @SerializedName("current")
    val currentWeatherEntry: CurrentWeatherEntry
)