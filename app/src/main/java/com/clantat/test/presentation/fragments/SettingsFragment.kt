package com.clantat.test.presentation.fragments

import android.app.Application
import android.content.Context
import android.os.Bundle
import android.util.TypedValue.COMPLEX_UNIT_SP
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatDelegate
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO
import androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_YES
import com.clantat.test.R
import com.clantat.test.core.App
import com.clantat.test.core.Constants
import com.clantat.test.core.Constants.SP_SETTINGS_FONT_SIZE
import com.clantat.test.core.Constants.SP_SETTINGS_THEME_MODE
import com.clantat.test.presentation.presenters.SettingsPresenter
import com.clantat.test.presentation.views.SettingsView
import kotlinx.android.synthetic.main.fragment_settings.view.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

private const val TAG: String = "SettingsFragment"
private const val THEME_MODE = "themeMode"

class SettingsFragment : MvpAppCompatFragment(), SettingsView {
    lateinit var changeThemeBtn: Button
    private var themeMode: String? = null

    @Inject
    lateinit var presenterProvider: Provider<SettingsPresenter>

    @InjectPresenter
    lateinit var settingsPresenter: SettingsPresenter

    @ProvidePresenter
    fun providePresenter(): SettingsPresenter {
        return presenterProvider.get()
    }

    override fun onAttach(context: Context) {
        super.onAttach(context)
        App.instance.plusSettingsFragmentComponent().inject(this)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            themeMode = it.getString(THEME_MODE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)
        changeThemeBtn = view.changeThemeBtn
        var fontSize: Float = App.instance.getSharedPreferences(
            Constants.SP_SETTINGS,
            Application.MODE_PRIVATE
        ).getFloat(SP_SETTINGS_FONT_SIZE, resources.getDimension(R.dimen.default_font_size))
        view.scrollViewText.setTextSize(COMPLEX_UNIT_SP,fontSize)
        when (AppCompatDelegate.getDefaultNightMode()) {
            MODE_NIGHT_NO -> {
                changeThemeBtn.text = resources.getString(R.string.changeLightTheme)
            }
            MODE_NIGHT_YES -> {
                changeThemeBtn.text = resources.getString(R.string.changeDarkTheme)
            }
            else -> {
                changeThemeBtn.text = resources.getString(R.string.changeLightTheme)
            }
        }
        changeThemeBtn.setOnClickListener {
            when (AppCompatDelegate.getDefaultNightMode()) {
                MODE_NIGHT_NO -> {
                    App.instance.getSharedPreferences(
                        Constants.SP_SETTINGS,
                        Application.MODE_PRIVATE
                    ).edit().putInt(SP_SETTINGS_THEME_MODE, MODE_NIGHT_YES).apply()
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                }
                MODE_NIGHT_YES -> {
                    App.instance.getSharedPreferences(
                        Constants.SP_SETTINGS,
                        Application.MODE_PRIVATE
                    ).edit().putInt(SP_SETTINGS_THEME_MODE, MODE_NIGHT_NO).apply()
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                }
                else -> {
                    App.instance.getSharedPreferences(
                        Constants.SP_SETTINGS,
                        Application.MODE_PRIVATE
                    ).edit().putInt(SP_SETTINGS_THEME_MODE, MODE_NIGHT_NO).apply()
                }
            }
        }
        view.decrease_btn.setOnClickListener {
            fontSize -= 2
            view.scrollViewText.setTextSize(COMPLEX_UNIT_SP,fontSize)
            App.instance.getSharedPreferences(
                Constants.SP_SETTINGS,
                Application.MODE_PRIVATE
            ).edit().putFloat(SP_SETTINGS_FONT_SIZE, fontSize).apply()
        }
        view.increase_btn.setOnClickListener {
            fontSize += 2
            view.scrollViewText.setTextSize(COMPLEX_UNIT_SP,fontSize)
            App.instance.getSharedPreferences(
                Constants.SP_SETTINGS,
                Application.MODE_PRIVATE
            ).edit().putFloat(SP_SETTINGS_FONT_SIZE, fontSize).apply()
        }
        return view
    }


    override fun changeTheme(modeTheme: Int) {
        AppCompatDelegate.setDefaultNightMode(modeTheme)
    }

    override fun showError(message: String) {
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
    }

    override fun showResult(message: String) {
        Toast.makeText(this.context, message, Toast.LENGTH_SHORT).show()
    }

    override fun onDestroy() {
        super.onDestroy()
        App.instance.clearSettingsFragmentComponent()
    }

    companion object {
        fun newInstance() =
            SettingsFragment()
    }
}