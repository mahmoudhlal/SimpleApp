package com.example.simpleapp.api

import com.example.simpleapp.model.Movie
import retrofit2.Response

interface ApiHelper {

    fun getMovies(): Response<List<Movie>>

}