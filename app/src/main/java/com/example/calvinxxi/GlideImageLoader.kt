package com.example.calvinxxi

import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide

class GlideImageLoader(private val context : Fragment) : ImageLoader {

    override fun loadImage(imageUrl : String, imageView: ImageView)
    {
        Glide.with(context)
            .load(imageUrl)
            .centerCrop()
            .into(imageView)
    }

}