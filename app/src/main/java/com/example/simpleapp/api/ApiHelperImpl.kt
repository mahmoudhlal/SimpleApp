package com.example.simpleapp.api

import com.example.simpleapp.model.Movie
import retrofit2.Response
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getMovies(): Response<List<Movie>> = apiService.getMovies()

}
