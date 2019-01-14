package com.jaede.moviesontips.controller

import com.jaede.moviesontips.data.model.MovieListResponse
import com.jaede.moviesontips.data.model.PostResponseStatus
import com.jaede.moviesontips.data.model.Rating
import io.reactivex.Single

/**
 * Created by jyotidubey on 28/12/18.
 */
interface MovieController{
    fun getTopRatedMovies() : Single<MovieListResponse>
    fun getNowPlayingMovies(page:Int): Single<MovieListResponse>
    fun getUpcomingMovies(): Single<MovieListResponse>
    fun rateMovie(movieId: Long, rating: Rating):Single<PostResponseStatus>
}