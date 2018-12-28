package com.jaede.moviesontips

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.jaede.moviesontips.data.api.MovieService
import com.jaede.moviesontips.data.api.MovieServiceGenerator
import com.jaede.moviesontips.data.api.MovieServiceGenerator.createService
import com.jaede.moviesontips.data.model.MovieListResponse
import retrofit2.Response
import retrofit2.Call
import retrofit2.Callback


class MovieListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_movie_list)

        val service = MovieServiceGenerator.createService(MovieService::class.java)
       // val response = service.getMovies("f2af324d24d5fc7b711d9328bdd83f36","en-US",1).execute()


        service.getMovies("f2af324d24d5fc7b711d9328bdd83f36","en-US",1).enqueue(object : Callback<MovieListResponse> {
            override fun onResponse(call: Call<MovieListResponse>, response: Response<MovieListResponse>) {
                val user = response.body()
            }

            override fun onFailure(call: Call<MovieListResponse>, throwable: Throwable) {
                println(throwable)
            }
        })

    }

}
