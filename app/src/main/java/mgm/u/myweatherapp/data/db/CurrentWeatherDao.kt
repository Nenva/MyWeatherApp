package mgm.u.myweatherapp.data.db

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import mgm.u.myweatherapp.data.db.entity.CURRENT_WEATHER_ID
import mgm.u.myweatherapp.data.db.entity.CurrentWeatherEntry
import mgm.u.myweatherapp.data.db.unitlocalized.ImperialCurrentWeatherEntry
import mgm.u.myweatherapp.data.db.unitlocalized.MetricCurrentWeatherEntry
import mgm.u.myweatherapp.data.db.unitlocalized.UnitSpecificCurrentWeatherEntry

@Dao
interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun upsert(weatherEntry: CurrentWeatherEntry)

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherMetric(): LiveData<MetricCurrentWeatherEntry>

    @Query("select * from current_weather where id = $CURRENT_WEATHER_ID")
    fun getWeatherImperial(): LiveData<ImperialCurrentWeatherEntry>
}