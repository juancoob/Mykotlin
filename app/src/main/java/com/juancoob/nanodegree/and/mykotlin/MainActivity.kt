package com.juancoob.nanodegree.and.mykotlin

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        checkFirstLetter();
        setMainMessage();
    }

    /**
     * Checks if the first letter is uppercase
     */
    fun checkFirstLetter() {
        Log.d("HiTag", isFirstLetterUppercase("Hi").toString())
        Log.d("HiTag", isFirstLetterUppercase("HI").toString())
        Log.d("HiTag", isFirstLetterUppercase("HI hi").toString())
        Log.d("HiTag", isFirstLetterUppercase("hI").toString())
        Log.d("HiTag", isFirstLetterUppercase("hi").toString())
        Log.d("HiTag", isFirstLetterUppercase("hiI! Hi").toString())
        Log.d("HiTag", isFirstLetterUppercase("hi!!").toString())
        Log.d("HiTag", isFirstLetterUppercase("hi!! Hi").toString())
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
        tv_hello_message.text = getString(R.string.hello_kotlin);
    }
}
