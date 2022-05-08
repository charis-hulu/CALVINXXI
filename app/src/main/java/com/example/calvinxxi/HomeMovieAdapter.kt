package com.example.calvinxxi

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeMovieAdapter(val c: MainActivity): RecyclerView.Adapter<HomeMovieAdapter.ListViewHolder>(){

    private lateinit var glideImageLoader: GlideImageLoader
    val movieList = MovieList.getMovies()


    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{
        var movieTitle = itemView.findViewById<TextView>(R.id.movieTitle)
        var movieGenre = itemView.findViewById<TextView>(R.id.movieGenre)
        var movieImage = itemView.findViewById<ImageView>(R.id.movieImage)

        override fun onClick(p0: View?) {
            TODO("Not yet implemented")
        }
        init {
            itemView.setOnClickListener(this)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.movie_card,parent,false)

        return ListViewHolder(v)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        glideImageLoader = GlideImageLoader(c)
        Log.d("Main Activity", movieList.toString())
        holder.movieTitle.text = movieList[position].title
        holder.movieGenre.text = movieList[position].genre
        glideImageLoader.loadImage(movieList[position].image_url, holder.movieImage)
    }

    override fun getItemCount(): Int {
        return movieList.size
    }


}