package com.clantat.test.presentation.fragments

import android.content.Context
import android.os.Bundle
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
        when (AppCompatDelegate.getDefaultNightMode()) {
            MODE_NIGHT_NO -> {
                changeThemeBtn.text = resources.getString(R.string.changeLightTheme)
            }
            MODE_NIGHT_YES -> {
                changeThemeBtn.text = resources.getString(R.string.changeDarkTheme)
            }
            AppCompatDelegate.MODE_NIGHT_UNSPECIFIED -> {
                changeThemeBtn.text = resources.getString(R.string.changeLightTheme)
            }
        }
        changeThemeBtn.setOnClickListener {
            when (AppCompatDelegate.getDefaultNightMode()) {
                MODE_NIGHT_NO -> {
                    settingsPresenter.changeModeTheme(MODE_NIGHT_YES)
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_YES)
                }
                MODE_NIGHT_YES -> {
                    settingsPresenter.changeModeTheme(MODE_NIGHT_NO)
                    AppCompatDelegate.setDefaultNightMode(MODE_NIGHT_NO)
                }
                AppCompatDelegate.MODE_NIGHT_UNSPECIFIED -> {
                    settingsPresenter.addModeTheme(MODE_NIGHT_YES)
                }
            }
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