package com.example.simpleapp.di.component

import com.example.simpleapp.api.ApiHelper
import com.example.simpleapp.di.module.ApplicationModule
import com.example.simpleapp.ui.MainActivity
import com.example.simpleapp.utils.NetworkHelper
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [ApplicationModule::class])
interface AppComponent{

    fun getApiHelper() : ApiHelper

    fun getNetworkHelper() : NetworkHelper

}