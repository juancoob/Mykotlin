package com.juancoob.nanodegree.and.mykotlin.data

import java.util.*

/**
 * Data classes to save data
 *
 * Created by Juan Antonio Cobos Obrero on 28/10/18.
 */
data class ForecastResult(val city : City, val list : List<Forecast>)

data class City(val id: Long, val name : String, val coord : Coordinates, val country : String,
                val population : Int)

data class Coordinates(val lon : Float, val lat : Float)

data class Forecast(val dt : Long, val temp : Temperature, val pressure : Float, val humidity : Int,
                    val weather : List<Weather>, val speed : Float, val deg : Int, val clouds : Int,
                    val rain : Float)

data class Temperature(val day: Float, val min: Float, val max: Float, val night: Float,
                       val eve: Float, val morn: Float)

data class Weather(val id: Long, val main: String, val description: String, val icon: String)

data class dummyForecast(val date : Date, val temperature : Float, val detail : String)
