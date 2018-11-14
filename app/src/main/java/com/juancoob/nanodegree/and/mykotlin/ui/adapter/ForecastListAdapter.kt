package com.juancoob.nanodegree.and.mykotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView
import com.juancoob.nanodegree.and.mykotlin.domain.model.ForecastList

/**
 * RecyclerView adapter to show the forecast
 *
 * Created by Juan Antonio Cobos Obrero on 24/10/18.
 */
class ForecastListAdapter(private val weekForecast: ForecastList) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder?>() {
    override fun getItemCount(): Int = weekForecast.dailyForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(weekForecast.dailyForecast[position]) {
            holder.textView.text = "$date - $description - $high/$low"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int) =
            ViewHolder(TextView(parent.context))

    class ViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)
}