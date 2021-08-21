package com.example.simpleapp

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.simpleapp.repository.MainRepository
import com.example.simpleapp.ui.MainViewModel
import com.example.simpleapp.utils.NetworkHelper
import java.lang.IllegalArgumentException

class ViewModelFactory (private val mainRepository: MainRepository,
                        private val networkHelper: NetworkHelper
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java))
            return MainViewModel(mainRepository, networkHelper) as T
        else
            throw IllegalArgumentException("Unknown class name")
    }
}