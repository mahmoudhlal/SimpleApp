package com.example.simpleapp.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.simpleapp.App
import com.example.simpleapp.R
import com.example.simpleapp.api.ApiService
import com.example.simpleapp.di.component.DaggerAppComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        (this.application as App).component.inject(this)


    }


}