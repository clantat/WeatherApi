package com.example.test

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_weather.*
import kotlinx.android.synthetic.main.fragment_weather.view.*

private const val CITY_NUMBER = "CITY_NUMBER"
private const val TAG = "WEATHER FRAGMENT"

class WeatherFragment : Fragment() {
    private var cityNumber: String? = null
    private var temp: String? = null
    private var degreesTextView: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cityNumber = it.getString(CITY_NUMBER)
        }
        if (savedInstanceState == null) {
            val apiService = GismeteoApiService.create()
            apiService.search()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    temp = it.list.get(0).main.temp
                }, { error("GG") }, {
                    degreesTextView?.text = "Температура в Ижевске ${temp}C"
                })
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        degreesTextView = view.degrees
        return view
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