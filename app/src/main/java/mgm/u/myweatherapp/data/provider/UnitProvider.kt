package mgm.u.myweatherapp.data.provider

import mgm.u.myweatherapp.internal.UnitSystem

interface UnitProvider {
    fun getUnitSystem(): UnitSystem
}