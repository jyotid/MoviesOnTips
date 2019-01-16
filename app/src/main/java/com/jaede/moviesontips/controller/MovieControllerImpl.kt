package com.jaede.moviesontips.controller

import com.jaede.moviesontips.data.api.ApiResponseCallback
import com.jaede.moviesontips.data.api.MovieApi
import com.jaede.moviesontips.data.model.ApiError
import com.jaede.moviesontips.data.model.MovieListResponse
import com.jaede.moviesontips.data.model.PostResponseStatus
import com.jaede.moviesontips.data.model.Rating
import io.reactivex.Single

/**
 * Created by jyotidubey on 28/12/18.
 */
class MovieControllerImpl(private var api: MovieApi) : MovieController {

    override fun getTopRatedMovies(page:Int) : Single<MovieListResponse> {
        return Single.create { s ->
            api.getTopRatedMovies(object : ApiResponseCallback<MovieListResponse> {
                override fun onSuccess(response: MovieListResponse) {
                    s.onSuccess(response)
                }
                override fun onError(throwable: ApiError) {
                    s.onError(throwable)
                }
            })
        }
    }

    override fun getNowPlayingMovies(page:Int): Single<MovieListResponse> {
        return Single.create { s ->
            api.getNowPlayingMovies(page,object : ApiResponseCallback<MovieListResponse> {
                override fun onSuccess(response: MovieListResponse) {
                    s.onSuccess(response)
                }
                override fun onError(throwable: ApiError) {
                    s.onError(throwable)
                }
            })

        }    }

    override fun getUpcomingMovies(page:Int): Single<MovieListResponse> {
        return Single.create { s ->
            api.getUpcomingMovies(object : ApiResponseCallback<MovieListResponse> {
                override fun onSuccess(response: MovieListResponse) {
                    s.onSuccess(response)
                }
                override fun onError(throwable: ApiError) {
                    s.onError(throwable)
                }
            })

        }
    }

    override fun rateMovie(movieId: Long, rating: Rating): Single<PostResponseStatus> {
        return Single.create { s ->
            api.rateMovie(movieId,rating, object : ApiResponseCallback<PostResponseStatus> {
                override fun onSuccess(response: PostResponseStatus) {
                    s.onSuccess(response)
                }
                override fun onError(throwable: ApiError) {
                    s.onError(throwable)
                }
            })

        }
    }
}