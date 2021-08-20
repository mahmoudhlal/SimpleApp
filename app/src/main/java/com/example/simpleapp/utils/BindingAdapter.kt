package com.example.simpleapp.utils

import android.graphics.drawable.GradientDrawable
import android.widget.ImageView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView


@BindingAdapter("adapter")
fun setAdapter(recyclerView: RecyclerView, adapter: RecyclerView.Adapter<RecyclerView.ViewHolder>?) {
    if (adapter != null) {
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)

    }
}

@BindingAdapter("backGroundColor")
fun setBackGroundColor(view: ImageView, color : GradientDrawable?) {
    if (color != null)
        view.background = color
}