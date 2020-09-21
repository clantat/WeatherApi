package com.example.test

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_weather.view.*
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

private const val CITY_NUMBER = "CITY_NUMBER"
private const val TAG = "WEATHER FRAGMENT"

class WeatherFragment : Fragment() {
    private var cityNumber: String? = null
    private var temp: String? = null
    private var humidity: String? = null
    private lateinit var degreesTextView: TextView
    private lateinit var humidityTextView: TextView
    private val viewModelScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cityNumber = it.getString(CITY_NUMBER)
        }
        if (savedInstanceState == null) {
            val apiService = GismeteoApiService.createRX()
            apiService.searchRX()
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe({
                    temp = it.list.get(0).main.temp
                }, { error("GG") }, {
                    degreesTextView.text = "Температура в Ижевске ${temp}C"
                })
        }

        GlobalScope.launch(Dispatchers.IO) {
            val apiService = GismeteoApiService.createCoroutines()
            humidity = apiService.searchCoroutine().await().list.get(0).main.humidity
            humidityTextView.text = "Влажность в Ижевске ${humidity}Ф"
        }

    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_weather, container, false)
        degreesTextView = view.degrees
        humidityTextView = view.humidity
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