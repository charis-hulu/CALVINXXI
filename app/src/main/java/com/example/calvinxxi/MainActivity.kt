package com.example.calvinxxi

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MainActivity : AppCompatActivity() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.252.242.192:5000/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val movieService = retrofit.create(movieAPI::class.java)
    lateinit var listRV : RecyclerView


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.home_fragment)
        this.getMovieResponse()

        listRV = findViewById(R.id.movie_rv)

        listRV.layoutManager = LinearLayoutManager(this)

        listRV.adapter = HomeMovieAdapter(this)


//        var youTubePlayerView: YouTubePlayerView = findViewById(R.id.youtube_player_view)
//        lifecycle.addObserver(youTubePlayerView)
    }

    private fun getMovieResponse() {

        val call = movieService.getAllMovies()

        call.enqueue(object : Callback<List<MovieResultData>> {

            override fun onResponse(call: Call<List<MovieResultData>>, response: Response<List<MovieResultData>>) {
                if(response.isSuccessful) {
                    //mainResponseView.text = response.body()
                    val results = response.body()

                    if(results?.isNotEmpty() == true) {

                        for (i in results.indices){
                            MovieList.addMovie(results[i].id,
                            results[i].title,
                            results[i].genre,
                            results[i].duration,
                            results[i].url_trailer,
                            results[i].synopsis,
                            results[i].director,
                            results[i].cast,
                            results[i].status,
                            results[i].image_url)
                        }
//                    Log.d("Main Activity", MovieList.getMovies()[0].title)
                    }
                    else
                    {
                        Log.d("MainActivity", "Cara pengambilan data salah")
                    }

                }
                else
                {
                    Log.e("MainActivity", "Gagal")
                }
            }

            override fun onFailure(call: Call<List<MovieResultData>>, t: Throwable) {
                Log.e("MainActivity", "Gagal Akses ke The Movie Api", t)
            }

        })



    }


}