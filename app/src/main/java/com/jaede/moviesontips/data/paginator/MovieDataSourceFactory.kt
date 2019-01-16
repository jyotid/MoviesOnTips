package com.jaede.moviesontips.data.paginator

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.jaede.moviesontips.data.model.Movie


/**
 * Created by jyotidubey on 13/01/19.
 */
class MovieDataSourceFactory(private var type : MOVIE_TYPE) : DataSource.Factory<Int,Movie>(){
    enum class MOVIE_TYPE {
        NOW_RUNNING, UPCOMING, TOP_RATED
    }

    val movies : MutableLiveData<MovieDataSource> = MutableLiveData()

    override fun create(): DataSource<Int,Movie> {
        var movieDataSource : MovieDataSource = UpcomingMovieDataSource()
        when(type){
            MOVIE_TYPE.NOW_RUNNING-> movieDataSource = NowRunningMovieDataSource()
            MOVIE_TYPE.UPCOMING-> movieDataSource = UpcomingMovieDataSource()
            MOVIE_TYPE.TOP_RATED-> movieDataSource = TopRatedMovieDataSource()
        }
        movies.postValue(movieDataSource)
        return movieDataSource
    }



}