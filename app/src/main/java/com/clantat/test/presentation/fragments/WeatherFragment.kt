package com.clantat.test.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.clantat.test.R
import com.clantat.test.core.App
import com.clantat.test.presentation.presenters.WeatherPresenter
import com.clantat.test.presentation.views.WeatherView
import kotlinx.android.synthetic.main.fragment_weather.view.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


private const val CITY_NUMBER = "CITY_NUMBER"

class WeatherFragment : MvpAppCompatFragment(), WeatherView {

    @Inject
    lateinit var presenterProvider: Provider<WeatherPresenter>

    @InjectPresenter
    lateinit var weatherPresenter: WeatherPresenter

    private var cityNumber: String? = null
    private lateinit var degreesTextView: TextView
    private lateinit var humidityTextView: TextView

    @ProvidePresenter
    fun provideWeatherPresenter(): WeatherPresenter {
        return presenterProvider.get()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.instance.plusWeatherFragmentComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            cityNumber = it.getString(CITY_NUMBER)
        }
        if (savedInstanceState == null) {
            weatherPresenter.start()
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

    override fun onDestroy() {
        App.instance.clearWeatherFragmentComponent()
        super.onDestroy()
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


    override fun showHumidity(humidity: String) {
        humidityTextView.text = humidity
    }

    override fun showDegrees(degrees: String) {
        degreesTextView.text = degrees
    }


}