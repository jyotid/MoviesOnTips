package com.jaede.moviesontips.api

import com.jaede.moviesontips.BuildConfig
import com.jaede.moviesontips.data.api.MovieService
import com.jaede.moviesontips.data.api.MovieServiceGenerator
import com.jaede.moviesontips.data.model.MovieListResponse
import io.reactivex.Single
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

/**
 * Created by jyotidubey on 28/12/18.
 */
class MovieApiImpl(private var service: MovieService) : MovieApi{
    init {
        service = MovieServiceGenerator.createService(MovieService::class.java)
    }

    override fun getTopRatedMovies(callback: ApiResponseCallback<MovieListResponse>){
        service.getMovies(BuildConfig.ApiKey,"en-US",1)
                .enqueue(object : Callback<MovieListResponse> {
                    override fun onResponse(call: Call<MovieListResponse>, response: Response<MovieListResponse>) {
                        val user = response.body()
                        callback.onSuccess(user!!)
                    }

                    override fun onFailure(call: Call<MovieListResponse>, throwable: Throwable) {
                        callback.onError(throwable)
                    }
                })
    }





}