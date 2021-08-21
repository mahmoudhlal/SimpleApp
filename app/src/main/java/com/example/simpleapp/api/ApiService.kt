package com.example.simpleapp.api

import com.example.simpleapp.model.Movie
import retrofit2.http.GET
import io.reactivex.Observable

interface ApiService {

    @GET("movies")
    fun getMovies(): Observable<List<Movie>>

}