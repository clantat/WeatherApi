package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment

private const val CITY_NUMBER = "CITY_NUMBER"

class WeatherFragment : Fragment() {
    private var cityNumber: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cityNumber = it.getString(CITY_NUMBER)
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_weather, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(cityNumber: String) =
            WeatherFragment().apply {
                arguments = Bundle().apply {
                    putString(CITY_NUMBER, cityNumber)
                }
            }
    }
}