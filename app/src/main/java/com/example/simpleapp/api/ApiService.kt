package com.example.simpleapp.api

import com.example.simpleapp.model.Movie
import retrofit2.Response
import retrofit2.http.GET

interface ApiService {

    @GET("movies")
    fun getMovies(): Response<List<Movie>>

}