package com.example.simpleapp.ui

import android.graphics.drawable.GradientDrawable
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.simpleapp.model.Movie
import com.example.simpleapp.utils.getRandomColor
import java.text.FieldPosition

class MainItemViewModel(movie: Movie) : ViewModel() {

    val name = MutableLiveData("")
    val isDownloaded = MutableLiveData(false)
    val color = MutableLiveData(GradientDrawable())

    init {
        name.value = movie.name
        isDownloaded.value = movie.isDownloaded
        color.value = getRandomColor()
    }



}