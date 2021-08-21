package com.example.simpleapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapp.model.Movie
import com.example.simpleapp.repository.MainRepository
import com.example.simpleapp.utils.NetworkHelper
import com.example.simpleapp.utils.Resource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val networkHelper: NetworkHelper
) : ViewModel(){

    private val _movies = MutableLiveData<Resource<List<Movie>>>()

    val movies: LiveData<Resource<List<Movie>>>
        get() = _movies

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        _movies.postValue(Resource.loading(null))
        if (networkHelper.isNetworkConnected()) {
            mainRepository.getMovies()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({
                    _movies.postValue(Resource.success(it))
                },{
                    _movies.postValue(it.message?.let { it1 -> Resource.error(it1, null) })
                },{
                    println("onComplete")
                })
            } else
                _movies.postValue(Resource.error("No internet connection", null))

    }
}
