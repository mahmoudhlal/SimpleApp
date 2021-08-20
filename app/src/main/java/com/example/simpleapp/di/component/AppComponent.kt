package com.example.simpleapp.di.component

import com.example.simpleapp.di.module.ApplicationModule
import com.example.simpleapp.ui.MainActivity
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface AppComponent {

    fun inject(mainActivity: MainActivity)

}