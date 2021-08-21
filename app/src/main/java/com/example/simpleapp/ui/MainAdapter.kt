package com.example.simpleapp.ui

import android.content.Context
import android.os.CountDownTimer
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.animation.Animation
import android.widget.Toast
import com.example.simpleapp.databinding.ViewMovieBinding
import com.example.simpleapp.model.Movie
import com.example.simpleapp.utils.BaseRecyclerAdapter
import com.example.simpleapp.utils.doDelay
import kotlinx.coroutines.newSingleThreadContext
import me.turkergoksu.lib.PercentageView

class MainAdapter(private var movies: ArrayList<Movie>) : BaseRecyclerAdapter<ViewMovieBinding>() {

    private var selectedPosition = -1
    private var isOtherFileDownloading = false


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        ViewHolder(
            ViewMovieBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )

    override fun getItemCount(): Int = movies.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = movies[position]
        holder.binding.vmItem = MainItemViewModel(item)

        if (selectedPosition == position)
            holder.binding.viewSelected.visibility = View.VISIBLE
        else
            if (item.isDownloaded.not())
                holder.binding.viewSelected.visibility = View.GONE
            else
                holder.binding.viewSelected.visibility = View.VISIBLE

        if (item.startDownloaded == 1) {
            holder.binding.percentageView.visibility = View.VISIBLE
            holder.binding.percentageView.setPercentage(100)
        }else{
            holder.binding.percentageView.visibility = View.GONE
        }

        holder.binding.root.setOnClickListener {
            onClick(position , it.context)
        }

        holder.binding.downloadBtn.setOnClickListener {
            downloadFile(position , it.context)
        }
    }

    fun addData(list: List<Movie>) {
        movies.addAll(list)
    }

    private fun onClick(position: Int, context : Context){
        if (isOtherFileDownloading.not()) {
            if (selectedPosition != position) {
                selectedPosition = position
                notifyDataSetChanged()
            }
        }else{
            Toast.makeText(context , "Please Waiting for downloading finish!" , Toast.LENGTH_SHORT).show()
        }
    }

    private fun downloadFile(position: Int , context : Context){
        if (movies[position].isDownloaded.not())
            if (isOtherFileDownloading.not()) {

                startDownload(position)

                doDelay({
                    onDownloadingFinished(position)
                },3000)

            }else{
                Toast.makeText(context , "Please Waiting for downloading finish!" , Toast.LENGTH_SHORT).show()
            }
    }

    private fun startDownload(position: Int){
        movies[position].startDownloaded = 1
        isOtherFileDownloading = true
        notifyItemChanged(position)
    }

    private fun onDownloadingFinished(position: Int){
        movies[position].startDownloaded = 0
        movies[position].isDownloaded = true
        notifyItemChanged(position)
        isOtherFileDownloading = false
    }

}
