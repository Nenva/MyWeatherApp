package mgm.u.myweatherapp.data.db.unitlocalized.future

import org.threeten.bp.LocalDate

interface UnitSpecificSimpleFutureWeatherEntry {
    val date: LocalDate
    val avgTemperature: Double
    val conditionText: String
    val conditionIconUrl: String
}