package com.juancoob.nanodegree.and.mykotlin.domain.model

/**
 * Domain classes
 *
 * Created by Juan Antonio Cobos Obrero on 4/11/18.
 */

data class ForecastList(val city: String, val country: String, val dailyForecast: List<anotherForecastDataClass>) {
    val size: Int
        get() = dailyForecast.size

    operator fun get(position: Int): anotherForecastDataClass = dailyForecast[position]
}

data class anotherForecastDataClass(val date: String, val description: String, val high: Int, val low: Int)