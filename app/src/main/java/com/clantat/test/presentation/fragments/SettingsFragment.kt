package com.clantat.test.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import com.clantat.test.R
import com.clantat.test.core.App
import com.clantat.test.presentation.presenters.SettingsPresenter
import com.clantat.test.presentation.views.SettingsView
import kotlinx.android.synthetic.main.fragment_root.view.*
import moxy.MvpAppCompatFragment
import moxy.presenter.InjectPresenter
import moxy.presenter.ProvidePresenter
import javax.inject.Inject
import javax.inject.Provider

class SettingsFragment : MvpAppCompatFragment(), SettingsView {

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
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_settings, container, false)

        return view
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