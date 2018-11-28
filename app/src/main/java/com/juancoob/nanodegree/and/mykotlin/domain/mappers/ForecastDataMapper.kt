package com.juancoob.nanodegree.and.mykotlin.domain.mappers

import com.juancoob.nanodegree.and.mykotlin.data.Forecast
import com.juancoob.nanodegree.and.mykotlin.data.ForecastResult
import com.juancoob.nanodegree.and.mykotlin.domain.model.ForecastList
import java.text.DateFormat
import com.juancoob.nanodegree.and.mykotlin.domain.model.anotherForecastDataClass as ModelForecast
import java.util.*
import java.util.concurrent.TimeUnit

/**
 * Class to map the JSON data
 *
 * Created by Juan Antonio Cobos Obrero on 6/11/18.
 */
class ForecastDataMapper {

    fun convertFromDataModel(forecast : ForecastResult): ForecastList =
            ForecastList(forecast.city.name, forecast.city.country, convertForecastListToDomain(forecast.list))

    private fun convertForecastListToDomain(list : List<Forecast>): List<ModelForecast> {
        return list.mapIndexed {index, forecast ->
            val dt = Calendar.getInstance().timeInMillis + TimeUnit.DAYS.toMillis(index.toLong())
            convertForecastItemToDomain(forecast.copy(dt = dt))
        }
    }

    private fun convertForecastItemToDomain(forecast: Forecast): ModelForecast {
        return ModelForecast(convertDate(forecast.dt), forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(), generateIconUrl(forecast.weather[0].icon))
    }

    private fun generateIconUrl(iconCode : String) : String
            = "http://openweathermap.org/img/w/$iconCode.png"

    private fun convertDate(date : Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date)
    }

}