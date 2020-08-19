package mgm.u.myweatherapp

import android.app.Application
import android.content.Context
import androidx.preference.PreferenceManager
import com.google.android.gms.location.LocationServices
import com.jakewharton.threetenabp.AndroidThreeTen
import mgm.u.myweatherapp.data.db.ForecastDatabase
import mgm.u.myweatherapp.data.network.*
import mgm.u.myweatherapp.data.provider.LocationProvider
import mgm.u.myweatherapp.data.provider.LocationProviderImpl
import mgm.u.myweatherapp.data.provider.UnitProvider
import mgm.u.myweatherapp.data.provider.UnitProviderImpl
import mgm.u.myweatherapp.data.repository.ForecastRepository
import mgm.u.myweatherapp.data.repository.ForecastRepositoryImpl
import mgm.u.myweatherapp.ui.weather.current.CurrentWeatherViewModelFactory
import org.kodein.di.KodeinAware
import org.kodein.di.Kodein
import org.kodein.di.android.x.androidXModule
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class ForecastApplication : Application(), KodeinAware {
    override val kodein = Kodein.lazy {
        import(androidXModule(this@ForecastApplication))

        bind() from singleton { ForecastDatabase(instance()) }
        bind() from singleton { instance<ForecastDatabase>().currentWeatherDao() }
        bind() from singleton { instance<ForecastDatabase>().weatherLocationDao() }
        bind<ConectivityInterceptor>() with singleton { ConectivityInterceptorImpl(instance()) }
        bind() from singleton { ApixuWeatherApiService(instance()) }
        bind<WeatherNetworkDataSource>() with singleton { WeatherNetworkDataSourceImpl(instance()) }
        bind() from provider { LocationServices.getFusedLocationProviderClient(instance<Context>()) }
        bind<LocationProvider>() with singleton { LocationProviderImpl(instance(), instance()) }
        bind<ForecastRepository>() with singleton { ForecastRepositoryImpl(instance(), instance(), instance(), instance()) }
        bind<UnitProvider>() with singleton { UnitProviderImpl(instance())}
        bind() from provider {CurrentWeatherViewModelFactory(instance(), instance())}
    }

    override fun onCreate() {
        super.onCreate()
        AndroidThreeTen.init(this)
        PreferenceManager.setDefaultValues(this, R.xml.preferences, false)
    }
}