package com.example.simpleapp.ui

import android.graphics.drawable.GradientDrawable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapp.model.Movie
import com.example.simpleapp.utils.getRandomColor

class MainItemViewModel(private val movie: Movie) : ViewModel() {

    val name = MutableLiveData("")
    val color = MutableLiveData(GradientDrawable())

    init {
        name.value = movie.name
        color.value = getRandomColor()
    }
}