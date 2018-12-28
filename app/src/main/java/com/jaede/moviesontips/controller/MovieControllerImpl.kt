package com.jaede.moviesontips.controller

import com.jaede.moviesontips.api.ApiResponseCallback
import com.jaede.moviesontips.api.MovieApi
import com.jaede.moviesontips.data.model.MovieListResponse
import io.reactivex.Single

/**
 * Created by jyotidubey on 28/12/18.
 */
class MovieControllerImpl(private var api: MovieApi) : MovieController {

    override fun getTopRatedMovies() : Single<MovieListResponse> {
        return Single.create { s ->
            api.getTopRatedMovies(object : ApiResponseCallback<MovieListResponse> {
                override fun onSuccess(response: MovieListResponse) {
                    s.onSuccess(response)
                }
                override fun onError(throwable: Throwable) {
                    println(throwable)
                }
            })

        }
    }
}