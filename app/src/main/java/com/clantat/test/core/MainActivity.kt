package com.clantat.test.core

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.clantat.test.R
import ru.terrakok.cicerone.android.support.SupportAppNavigator
import javax.inject.Inject


class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var app: App
    private val navigator = SupportAppNavigator(this, R.id.root_container)

    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.plusMainActivityComponent().inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            app.cicerone.router.newRootScreen(RootScreen())
        }

    }

    override fun onResumeFragments() {
        super.onResumeFragments()
        app.cicerone.navigatorHolder.setNavigator(navigator)
    }

    override fun onPause() {
        super.onPause()
        app.cicerone.navigatorHolder.removeNavigator()
    }

    override fun onDestroy() {
        super.onDestroy()
        App.instance.clearMainActivityComponent()
    }
}