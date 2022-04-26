package com.example.calvinxxi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class HomeMovieAdapter(val c: MainActivity, var movieList: ArrayList<MovieData>): RecyclerView.Adapter<HomeMovieAdapter.ListViewHolder>(){
    inner class ListViewHolder(itemView: View): RecyclerView.ViewHolder(itemView), View.OnClickListener{

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
        TODO("Not yet implemented")
    }

    override fun getItemCount(): Int {
        TODO("Not yet implemented")
    }


}