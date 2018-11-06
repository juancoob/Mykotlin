package com.juancoob.nanodegree.and.mykotlin.domain.commands

import com.juancoob.nanodegree.and.mykotlin.data.ForecastRequest
import com.juancoob.nanodegree.and.mykotlin.domain.mappers.ForecastDataMapper
import com.juancoob.nanodegree.and.mykotlin.domain.model.ForecastList

/**
 * Class which get data from the JSON request
 *
 * Created by Juan Antonio Cobos Obrero on 6/11/18.
 */
class RequestForecastCommand(private val zipCode : String): Command<ForecastList> {

    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(forecastRequest.execute())
    }
}