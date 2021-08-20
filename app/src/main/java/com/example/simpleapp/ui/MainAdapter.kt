package com.example.simpleapp.ui

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.simpleapp.databinding.ViewMovieBinding
import com.example.simpleapp.model.Movie
import com.example.simpleapp.utils.BaseRecyclerAdapter

class MainAdapter(private val movies: ArrayList<Movie>) : BaseRecyclerAdapter<ViewMovieBinding>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ViewMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.vmItem = MainItemViewModel(movies[position])
    }

    fun addData(list: List<Movie>) {
        movies.addAll(list)
    }
}
