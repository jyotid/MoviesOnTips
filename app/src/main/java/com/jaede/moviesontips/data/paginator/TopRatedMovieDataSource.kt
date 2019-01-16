package com.jaede.moviesontips.data.paginator

import android.arch.lifecycle.MutableLiveData
import com.jaede.moviesontips.controller.MovieControllerImpl
import com.jaede.moviesontips.data.api.MovieApiImpl
import com.jaede.moviesontips.data.api.retrofit.MovieService
import com.jaede.moviesontips.data.api.retrofit.MovieServiceGenerator
import com.jaede.moviesontips.data.model.Movie

/**
 * Created by jyotidubey on 16/01/19.
 */
class TopRatedMovieDataSource: MovieDataSource(){
    private val isLoading : MutableLiveData<String> by lazy { MutableLiveData<String>() }

    val controller = MovieControllerImpl(MovieApiImpl(MovieServiceGenerator.createService(MovieService::class.java)))
    override fun loadInitial(params: LoadInitialParams<Int>, callback: LoadInitialCallback<Int, Movie>) {
        controller.getTopRatedMovies(1)
                .doOnSubscribe { isLoading.postValue("Loading") }
                .subscribe({result->
                    callback.onResult(result.movies,1,2)
                    isLoading.postValue("Loaded")
                },{})
    }

    override fun loadBefore(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {

    }

    override fun loadAfter(params: LoadParams<Int>, callback: LoadCallback<Int, Movie>) {
        controller.getTopRatedMovies(params.key)
                .subscribe({result->
                    val nextPage = if (result.movies.size==0) null else params.key.plus(1)
                    callback.onResult(result.movies,nextPage)
                },{})
    }


}