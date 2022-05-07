package com.example.calvinxxi

object MovieList {
    private val allMovies:ArrayList<MovieData> = ArrayList()

    fun getMovies(): ArrayList<MovieData>{
        return allMovies
    }

    fun addMovie(id: String, title: String, genre: String, duration: Int,  url_trailer: String, synopsis: String, director: String, cast: String, status: Int, image_url: String){
        allMovies.add(MovieData(id, title, genre, duration, url_trailer, synopsis, director, cast, status, image_url))
    }
}