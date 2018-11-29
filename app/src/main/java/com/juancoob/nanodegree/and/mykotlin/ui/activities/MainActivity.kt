package com.juancoob.nanodegree.and.mykotlin.ui.adapter

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.widget.Toast
import com.juancoob.nanodegree.and.mykotlin.R
import com.juancoob.nanodegree.and.mykotlin.data.dummyForecast
import com.juancoob.nanodegree.and.mykotlin.domain.commands.RequestForecastCommand
import com.juancoob.nanodegree.and.mykotlin.domain.model.anotherForecastDataClass
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.toast
import org.jetbrains.anko.uiThread
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkFirstLetter()
        setMainMessage()
        showToast(getString(R.string.hello_world))
        //populateWeatherList()
        initRecyclerView()
        getAsyncData()
        copyDummyForecastData()
    }

    /**
     * Shows a toast, but the useful code to learn are functions can use optional parameters and Anko extension function
     */
    private fun Context.showToast(text: String, className : String = MainActivity::class.java.simpleName,
                                  length : Int = Toast.LENGTH_SHORT) {
        Toast.makeText(this, "[$className] $text", length).show()
    }


    /**
     * Checks if the first letter is uppercase
     */
    fun checkFirstLetter() {
        Log.d(getString(R.string.hi_tag), isFirstLetterUppercase(getString(R.string.hi1)).toString())
        Log.d(getString(R.string.hi_tag), isFirstLetterUppercase(getString(R.string.hi2)).toString())
        Log.d(getString(R.string.hi_tag), isFirstLetterUppercase(getString(R.string.hi3)).toString())
        Log.d(getString(R.string.hi_tag), isFirstLetterUppercase(getString(R.string.hi4)).toString())
        Log.d(getString(R.string.hi_tag), isFirstLetterUppercase(getString(R.string.hi5)).toString())
        Log.d(getString(R.string.hi_tag), isFirstLetterUppercase(getString(R.string.hi6)).toString())
        Log.d(getString(R.string.hi_tag), isFirstLetterUppercase(getString(R.string.hi7)).toString())
        Log.d(getString(R.string.hi_tag), isFirstLetterUppercase(getString(R.string.hi8)).toString())
    }

    /**
     * Return if the first word letter is uppercase or not
     * @param wordToCheck The word to check
     * @return A boolean showing the result
     */
    fun isFirstLetterUppercase(wordToCheck: String): Boolean {
        val stringPattern = "^[A-Z].*"
        return wordToCheck.matches(stringPattern.toRegex())
    }

    /**
     *  Set the main message
     */
    fun setMainMessage() {
        tv_hello_message.text = getString(R.string.hello_kotlin)
    }

    /**
     * Init the dummy list to show it on the recyclerView
     */
    private fun populateWeatherList() = listOf(getString(R.string.monday), getString(R.string.tuesday), getString(R.string.wednesday),
                getString(R.string.thursday), getString(R.string.friday), getString(R.string.saturday), getString(R.string.sunday))

    /**
     * Initialise the recyclerView to show the weather
     */
    private fun initRecyclerView() {
        val forecastList = findViewById<RecyclerView>(R.id.rv_forecast_list)
        forecastList.layoutManager = LinearLayoutManager(this)
    }

    /**
     * Function to get data asynchronously
     */
    private fun getAsyncData() {
        doAsync {
            //Request(getString(R.string.vegan_url)).run()
            val result = RequestForecastCommand(getString(R.string.command_number)).execute()
            uiThread {
                //longToast(getString(R.string.success))
                rv_forecast_list.adapter = ForecastListAdapter(result,
                        object : ForecastListAdapter.OnItemClickListener {
                            override fun invoke(forecast: anotherForecastDataClass) {
                                toast(forecast.date)
                            }
                        });
            }
        }
    }

    /**
     * Function to copy data from the Forecast data class
     */
    private fun copyDummyForecastData() {
        val dummyForecast1 = dummyForecast(Date(), 20.4f, getString(R.string.cloudy))
        val dummyForecast2 = dummyForecast1.copy(temperature = 25.5f, detail = getString(R.string.sunny))
        val (date, temp, det) = dummyForecast2
        val areEquals = dummyForecast1.equals(dummyForecast2)
        Log.d(javaClass.simpleName, date.toString())
        Log.d(javaClass.simpleName, temp.toString())
        Log.d(javaClass.simpleName, det)
        Log.d(javaClass.simpleName, areEquals.toString())
    }
}
