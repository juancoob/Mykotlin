package com.juancoob.nanodegree.and.mykotlin

import android.support.v7.widget.RecyclerView
import android.view.ViewGroup
import android.widget.TextView

/**
 * Created by Juan Antonio Cobos Obrero on 24/10/18.
 */
class ForecastListAdapter(private val items: List<String>) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.textView.text = items[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType : Int): ViewHolder  = ViewHolder(TextView(parent.context))

    class ViewHolder(val textView : TextView) : RecyclerView.ViewHolder(textView)
}