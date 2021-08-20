package com.example.simpleapp.repository

import com.example.simpleapp.api.ApiHelper
import javax.inject.Inject

class MainRepository @Inject constructor(private val apiHelper: ApiHelper) {

    fun getMovies() =  apiHelper.getMovies()

}