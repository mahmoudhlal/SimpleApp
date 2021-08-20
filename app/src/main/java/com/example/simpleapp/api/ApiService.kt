package com.example.simpleapp.api

import com.example.simpleapp.model.Movie
import retrofit2.Response
import retrofit2.http.GET
import rx.Observable

interface ApiService {

    @GET("movies")
    fun getMovies(): Observable<List<Movie>>

}