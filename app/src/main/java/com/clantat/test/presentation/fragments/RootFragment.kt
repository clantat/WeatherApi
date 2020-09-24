package com.clantat.test.presentation.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.clantat.test.R
import kotlinx.android.synthetic.main.fragment_root.view.*


class RootFragment : Fragment() {
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
            fragmentManager
                ?.beginTransaction()
                ?.replace(R.id.root_container, WeatherFragment.newInstance("18"), "Weather")
                ?.addToBackStack(null)
                ?.commit()
        }
        return view
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