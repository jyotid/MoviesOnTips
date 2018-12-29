package com.jaede.moviesontips.data.api

import com.jaede.moviesontips.BuildConfig
import com.jaede.moviesontips.data.api.retrofit.MovieService
import com.jaede.moviesontips.data.api.retrofit.MovieServiceGenerator
import com.jaede.moviesontips.data.model.MovieListResponse
import com.jaede.moviesontips.data.model.PostResponseStatus
import com.jaede.moviesontips.data.model.Rating
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


/**
 * Created by jyotidubey on 28/12/18.
 */
class MovieApiImpl(private var service: MovieService) : MovieApi {
    init {
        service = MovieServiceGenerator.createService(MovieService::class.java)
    }

    override fun getTopRatedMovies(callback: ApiResponseCallback<MovieListResponse>) {
        service.getTopRatedMovies(BuildConfig.ApiKey, "en-US", 1)
                .enqueue(object : Callback<MovieListResponse> {
                    override fun onResponse(call: Call<MovieListResponse>, response: Response<MovieListResponse>) {
                        if (response.isSuccessful) {
                            val result = response.body()
                            callback.onSuccess(result!!)
                        } else {
                            val error = ErrorUtil.parseError(response)
                            callback.onError(error)
                        }
                    }

                    override fun onFailure(call: Call<MovieListResponse>, throwable: Throwable) {
                        callback.onError(throwable)
                    }
                })
    }

    override fun getNowPlayingMovies(callback: ApiResponseCallback<MovieListResponse>) {
        service.getNowRunningMovies(BuildConfig.ApiKey, "en-US", 1)
                .enqueue(object : Callback<MovieListResponse> {
                    override fun onResponse(call: Call<MovieListResponse>, response: Response<MovieListResponse>) {
                        if (response.isSuccessful) {
                            val result = response.body()
                            callback.onSuccess(result!!)
                        } else {
                            val error = ErrorUtil.parseError(response)
                            callback.onError(error)
                        }
                    }

                    override fun onFailure(call: Call<MovieListResponse>, throwable: Throwable) {
                        callback.onError(throwable)
                    }
                })
    }

    override fun getUpcomingMovies(callback: ApiResponseCallback<MovieListResponse>) {
        service.getUpcomingMovies(BuildConfig.ApiKey, "en-US", 1)
                .enqueue(object : Callback<MovieListResponse> {
                    override fun onResponse(call: Call<MovieListResponse>, response: Response<MovieListResponse>) {
                        if (response.isSuccessful) {
                            val result = response.body()
                            callback.onSuccess(result!!)
                        } else {
                            val error = ErrorUtil.parseError(response)
                            callback.onError(error)
                        }

                    }

                    override fun onFailure(call: Call<MovieListResponse>, throwable: Throwable) {
                        callback.onError(throwable)
                    }
                })
    }

    override fun rateMovie(movieId: Long, rating: Rating, callback: ApiResponseCallback<PostResponseStatus>) {
        service.rateMovie(19404, "f2af324d24d5fc7b711d9328bdd83f36", Rating(8.5f))
                .enqueue(object : Callback<PostResponseStatus> {
                    override fun onResponse(call: Call<PostResponseStatus>, response: Response<PostResponseStatus>) {
                        if (response.isSuccessful) {
                            val result = response.body()
                            callback.onSuccess(result!!)
                        } else {
                            val error = ErrorUtil.parseError(response)
                            callback.onError(error)
                        }

                    }

                    override fun onFailure(call: Call<PostResponseStatus>, throwable: Throwable) {
                        callback.onError(throwable)
                    }
                })
    }


}