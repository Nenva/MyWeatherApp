package mgm.u.myweatherapp.data.network

import androidx.lifecycle.LiveData
import mgm.u.myweatherapp.data.network.response.CurrentWeatherResponse
import mgm.u.myweatherapp.data.network.response.FutureWeatherResponse

interface WeatherNetworkDataSource {
    val downloadedCurrentWeather: LiveData<CurrentWeatherResponse>
    val downloadedFutureWeather: LiveData<FutureWeatherResponse>

    suspend fun fetchCurrentWeather(
        location: String,
        languageCode: String
    )

    suspend fun fetchFutureWeather(
        location: String,
        languageCode: String
    )
}