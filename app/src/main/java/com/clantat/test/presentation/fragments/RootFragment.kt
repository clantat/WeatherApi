package com.clantat.test.presentation.fragments

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.TypedValue
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import com.clantat.test.R
import com.clantat.test.core.App
import com.clantat.test.core.Constants
import com.clantat.test.presentation.presenters.RootPresenter
import com.clantat.test.presentation.views.RootView
import kotlinx.android.synthetic.main.fragment_root.view.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

private const val TAG: String = "RootFragment"

class RootFragment : MvpAppCompatFragment(), RootView {

    private lateinit var weatherBtn: Button
    private lateinit var settingsBtn: Button

    @Inject
    lateinit var presenterProvider: Provider<RootPresenter>

    @InjectPresenter
    lateinit var rootPresenter: RootPresenter

    @ProvidePresenter
    fun providePresenter(): RootPresenter {
        return presenterProvider.get()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.instance.plusRootFragmentComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_root, container, false)
        weatherBtn = view.weatherBTN
        if (this::weatherBtn.isInitialized)
            weatherBtn.setOnClickListener {
                rootPresenter.goToWeather()
            }
        settingsBtn = view.settingsBTN
        if (this::settingsBtn.isInitialized)
            settingsBtn.setOnClickListener {
                rootPresenter.goToSettings()
            }
        view.hello_user_tv.setTextSize(
            TypedValue.COMPLEX_UNIT_SP, App.instance.getSharedPreferences(
                Constants.SP_SETTINGS,
                Application.MODE_PRIVATE
            ).getFloat(
                Constants.SP_SETTINGS_FONT_SIZE,
                resources.getDimension(R.dimen.default_font_size)
            )
        )

        return view
    }

    override fun onDestroy() {
        super.onDestroy()
        App.instance.clearRootFragmentComponent()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RootFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }

    override fun setThemeMode(themeMode: Int) {
        AppCompatDelegate.setDefaultNightMode(themeMode)
    }

    override fun error(message: String) {
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
    }

}