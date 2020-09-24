package com.clantat.test.core

import androidx.fragment.app.Fragment
import com.clantat.test.presentation.fragments.RootFragment
import com.clantat.test.presentation.fragments.WeatherFragment
import ru.terrakok.cicerone.android.support.SupportAppScreen

class RootScreen : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return RootFragment.newInstance()
    }
}

class WeatherScreen(private val cityNumber: String) : SupportAppScreen() {
    override fun getFragment(): Fragment {
        return WeatherFragment.newInstance(cityNumber)
    }
}
