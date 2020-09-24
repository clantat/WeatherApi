package com.clantat.test.presentation.fragments

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.clantat.test.R
import com.clantat.test.core.App
import com.clantat.test.core.WeatherScreen
import kotlinx.android.synthetic.main.fragment_root.view.*


class RootFragment : Fragment() {

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
        view.weatherBTN?.setOnClickListener {
            App.instance.cicerone.router.navigateTo(WeatherScreen("18"))
        }
        return view
    }

    override fun onDestroy() {
        App.instance.clearRootFragmentComponent()
        super.onDestroy()
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            RootFragment().apply {
                arguments = Bundle().apply {
                }
            }
    }
}