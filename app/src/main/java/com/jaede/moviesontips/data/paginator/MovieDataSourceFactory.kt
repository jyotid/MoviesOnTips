package com.jaede.moviesontips.data.paginator

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.jaede.moviesontips.data.model.Movie


/**
 * Created by jyotidubey on 13/01/19.
 */
class MovieDataSourceFactory : DataSource.Factory<Int,Movie>(){

    private val movies : MutableLiveData<MovieDataSource> = MutableLiveData()

    override fun create(): DataSource<Int,Movie> {
        val movieDataSource = MovieDataSource()
        movies.postValue(movieDataSource)
        return movieDataSource
    }

    public fun getMovies()  = movies

}