package com.example.calvinxxi
import retrofit2.Call
import retrofit2.http.GET

interface movieAPI {

    @GET("all")
    fun getAllMovies() : Call<List<MovieResultData>>

}