package com.example.simpleapp.api

import com.example.simpleapp.model.Movie
import io.reactivex.Observable

interface ApiHelper {

    fun getMovies(): Observable<List<Movie>>

}