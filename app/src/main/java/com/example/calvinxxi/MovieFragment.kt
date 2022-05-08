package com.example.calvinxxi

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory

class MovieFragment : Fragment() {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://10.252.242.192:5000/")
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    private val movieService = retrofit.create(movieAPI::class.java)
    private lateinit var glideImageLoader: GlideImageLoader

    companion object {
        fun newInstance() = MovieFragment()
    }

    private lateinit var viewModel: MovieViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        this.getMovieResponse()
        glideImageLoader = GlideImageLoader(this)
        return inflater.inflate(R.layout.movie_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieViewModel::class.java)
        // TODO: Use the ViewModel
    }

    private fun getMovieResponse() {

        val call = movieService.getMovieDetail(2)
        Log.d("MainActivity", "Waiting fo respnse")

        call.enqueue(object : Callback<List<MovieResultData>> {

            override fun onResponse(call: Call<List<MovieResultData>>, response: Response<List<MovieResultData>>) {
                if(response.isSuccessful) {
                    //mainResponseView.text = response.body()
                    val results = response.body()
                    Log.d("MainActivity", "Responded")

                    if(results?.isNotEmpty() == true) {

                        for (i in results.indices){
//                            titleTV?.text = results[i].title
//                            genreTV?.text = results[i].genre
//                            durationTV?.text = results[i].duration.toString()
//                            imageTV?.let { glideImageLoader.loadImage(results[i].image_url, it) }
//                            synopisTV?.text = results[i].synopsis
//                            directorTV?.text = results[i].director
//                            castTV?.text = results[i].cast
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