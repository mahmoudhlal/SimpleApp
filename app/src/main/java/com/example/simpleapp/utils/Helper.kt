package com.example.simpleapp.utils

import android.graphics.Color
import android.graphics.drawable.GradientDrawable
import java.util.*


fun getRandomColor() : GradientDrawable{
    val r = Random()
    val red: Int = r.nextInt(255 - 0 + 1) + 0
    val green: Int = r.nextInt(255 - 0 + 1) + 0
    val blue: Int = r.nextInt(255 - 0 + 1) + 0

    val draw = GradientDrawable()
    draw.shape = GradientDrawable.OVAL
    draw.setColor(Color.rgb(red, green, blue))
    return draw
}