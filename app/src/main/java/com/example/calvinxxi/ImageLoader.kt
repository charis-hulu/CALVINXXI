package com.example.calvinxxi

import android.widget.ImageView

interface ImageLoader {

    fun loadImage(imageUrl : String, imageView: ImageView)

}