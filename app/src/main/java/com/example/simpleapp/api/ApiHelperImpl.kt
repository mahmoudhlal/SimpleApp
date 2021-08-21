package com.example.simpleapp.api

import com.example.simpleapp.model.Movie
import io.reactivex.Observable
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getMovies(): Observable<List<Movie>> = apiService.getMovies()

}
