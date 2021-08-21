package com.example.simpleapp.ui

import android.content.Context
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.simpleapp.databinding.ViewMovieBinding
import com.example.simpleapp.model.Movie
import com.example.simpleapp.utils.BaseRecyclerAdapter

class MainAdapter(private val movies: ArrayList<Movie>) : BaseRecyclerAdapter<ViewMovieBinding>() {

    private var selectedPosition = -1
    private var isDownloading = false

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ViewMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.vmItem = MainItemViewModel(movies[position])

        if (selectedPosition == position)
            holder.binding.viewSelected.visibility = View.VISIBLE
        else
            holder.binding.viewSelected.visibility = View.GONE

        holder.binding.root.setOnClickListener {
            onClick(position)
        }
        holder.binding.downloadBtn.setOnClickListener {
            downloadFile(position , it.context)
        }
    }

    fun addData(list: List<Movie>) {
        movies.addAll(list)
    }

    private fun onClick(position: Int){
        if (selectedPosition != position) {
            selectedPosition = position
            notifyDataSetChanged()
        }
    }

    private fun downloadFile(position: Int , context : Context){
        if (isDownloading.not()) {
            isDownloading = true
            Thread.sleep(3000)
            movies[position].isDownloaded = true
            notifyDataSetChanged()
            isDownloading = false
        }else{
            Toast.makeText(context , "Waiting for downloading finished!" , Toast.LENGTH_SHORT).show()
        }
    }

}
