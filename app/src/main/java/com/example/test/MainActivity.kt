package com.example.test

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity

private const val TAG = "MAIN ACTIVITY"

class MainActivity : AppCompatActivity() {
    //TODO добавить cicerone router
    override fun onCreate(savedInstanceState: Bundle?) {
        App.instance.appComponent.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .replace(R.id.root_container, RootFragment.newInstance(), "RootFragment")
                .commit()
        }
    }
}