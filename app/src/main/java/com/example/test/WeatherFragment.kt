package com.example.test

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers
import io.reactivex.rxjava3.schedulers.Schedulers
import kotlinx.android.synthetic.main.fragment_weather.view.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider


private const val CITY_NUMBER = "CITY_NUMBER"
private const val TAG = "WEATHER FRAGMENT"

class WeatherFragment : MvpAppCompatFragment(), WeatherView {

    @Inject
    lateinit var presenterProvider: Provider<WeatherPresenter>

    @InjectPresenter
    lateinit var weatherPresenter: WeatherPresenter

    //TODO ПОПРОБОВАТЬ ПОМЕНЯТЬ НА https://habr.com/ru/post/506806/  private val presenter by moxyPresenter { presenterProvider.get()}
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