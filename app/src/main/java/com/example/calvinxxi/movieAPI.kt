package com.example.calvinxxi
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface movieAPI {

    @GET("all")
    fun getAllMovies() : Call<List<MovieResultData>>

    @GET("details")
    fun getMovieDetail(@Query("movie_id") movie_id : Int) : Call<List<MovieResultData>>

    @GET("book")
    fun getBooks(@Query("movie_id") movie_id : Int) : Call<List<TicketBookingData>>
}