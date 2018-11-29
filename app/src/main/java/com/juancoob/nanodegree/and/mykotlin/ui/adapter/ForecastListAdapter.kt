package com.juancoob.nanodegree.and.mykotlin.ui.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.juancoob.nanodegree.and.mykotlin.R
import com.juancoob.nanodegree.and.mykotlin.domain.model.ForecastList
import com.juancoob.nanodegree.and.mykotlin.domain.model.anotherForecastDataClass
import com.juancoob.nanodegree.and.mykotlin.util.ctx
import com.squareup.picasso.Picasso
import org.jetbrains.anko.find

/**
 * RecyclerView adapter to show the forecast
 *
 * Created by Juan Antonio Cobos Obrero on 24/10/18.
 */
class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemCLick: ForecastListAdapter.OnItemClickListener) :
        RecyclerView.Adapter<ForecastListAdapter.ViewHolder?>() {
    override fun getItemCount(): Int = weekForecast.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindForecast(weekForecast[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) :
            ViewHolder {
        val view = LayoutInflater.from(parent.ctx) // We could use context instead of ctx
                .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemCLick)
    }

    class ViewHolder(view: View, private val itemCLick: OnItemClickListener) : RecyclerView.ViewHolder(view) {
        private val iconView = view.find<ImageView>(R.id.iv_icon)
        private val dateView = view.find<TextView>(R.id.tv_date)
        private val descriptionView = view.find<TextView>(R.id.tv_description)
        private val maxTemperatureView = view.find<TextView>(R.id.tv_max_temperature)
        private val minTemperatureView = view.find<TextView>(R.id.tv_min_temperature)

        fun bindForecast(forecast: anotherForecastDataClass) {
            with(forecast) {
                Picasso.get().load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "$high"
                minTemperatureView.text = "$low"
                itemView.setOnClickListener {
                    itemCLick(this)
                }
            }
        }
    }

    interface OnItemClickListener {
        operator fun invoke(forecast: anotherForecastDataClass)
    }
}