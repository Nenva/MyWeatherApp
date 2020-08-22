package mgm.u.myweatherapp.data.network.response


import com.google.gson.annotations.SerializedName
import mgm.u.myweatherapp.data.db.entity.FutureWeatherEntry

data class ForecastDaysContainer(
    @SerializedName("forecastday")
    val entries: List<FutureWeatherEntry>
)