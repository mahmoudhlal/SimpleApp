package com.example.simpleapp

import android.app.Application
import com.example.simpleapp.di.component.AppComponent
import com.example.simpleapp.di.component.DaggerAppComponent
import com.example.simpleapp.di.module.ApplicationModule

class App : Application() {

    lateinit var component: AppComponent

    override fun onCreate() {
        super.onCreate()

        createComponent()
    }

    protected open fun createComponent() {
        component = DaggerAppComponent.builder()
            .applicationModule(ApplicationModule())
            .build()
    }
}