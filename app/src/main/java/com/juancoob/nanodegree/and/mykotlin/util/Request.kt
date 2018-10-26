package com.juancoob.nanodegree.and.mykotlin.util

import android.util.Log
import java.net.URL

/**
 * Class to read the JSON data using an asynchronous operation
 *
 * Created by Juan Antonio Cobos Obrero on 26/10/18.
 */

class Request(private val url : String) {
    fun run() {
        val veganJsonString = URL(url).readText()
        Log.d(javaClass.simpleName, veganJsonString)
    }
}