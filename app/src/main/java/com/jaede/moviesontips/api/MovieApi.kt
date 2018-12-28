package com.jaede.moviesontips.api

import com.jaede.moviesontips.data.model.MovieListResponse

/**
 * Created by jyotidubey on 28/12/18.
 */
interface MovieApi{
    fun getTopRatedMovies(callback: ApiResponseCallback<MovieListResponse>)

}