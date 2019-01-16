package com.jaede.moviesontips.data.api

import com.jaede.moviesontips.data.model.MovieListResponse
import com.jaede.moviesontips.data.model.PostResponseStatus
import com.jaede.moviesontips.data.model.Rating

/**
 * Created by jyotidubey on 28/12/18.
 */
interface MovieApi{
    fun getTopRatedMovies(page: Int,callback: ApiResponseCallback<MovieListResponse>)
    fun getNowPlayingMovies(page:Int,callback: ApiResponseCallback<MovieListResponse>)
    fun getUpcomingMovies(page: Int,callback: ApiResponseCallback<MovieListResponse>)
    fun rateMovie(movieId: Long, rating: Rating,callback: ApiResponseCallback<PostResponseStatus>)


}