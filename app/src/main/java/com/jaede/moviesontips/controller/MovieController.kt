package com.jaede.moviesontips.controller

import com.jaede.moviesontips.data.model.MovieListResponse
import io.reactivex.Single

/**
 * Created by jyotidubey on 28/12/18.
 */
interface MovieController{
    fun getTopRatedMovies() : Single<MovieListResponse>
}