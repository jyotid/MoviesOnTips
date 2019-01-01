package com.jaede.moviesontips.ui.movie

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jaede.moviesontips.controller.MovieController
import com.jaede.moviesontips.data.model.Movie
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

/**
 * Created by jyotidubey on 29/12/18.
 */
class MovieListViewModel(private var controller: MovieController) : ViewModel() {

    val item : MutableLiveData<List<MovieItemUiState>> by lazy {
        MutableLiveData<List<MovieItemUiState>>()
    }

    init {
        loadNowRunningMovies()
    }

    fun loadNowRunningMovies(){
        controller.getNowPlayingMovies()
                .map { movieResponse->movieResponse.movies  }
                .map { movies->
                    val movieItemUiState= mutableListOf<MovieItemUiState>()
                    movies.mapTo(movieItemUiState) { MovieItemUiState(it) }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({movies-> item.value = movies},{})
    }

    fun loadUpcomingMovies(){
        controller.getUpcomingMovies()
                .map { movieResponse->movieResponse.movies  }
                .map { movies->
                    val movieItemUiState= mutableListOf<MovieItemUiState>()
                    movies.mapTo(movieItemUiState) { MovieItemUiState(it) }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({movies-> item.value = movies},{})    }

    fun loadTopRatedMovies(){
        controller.getTopRatedMovies()
                .map { movieResponse->movieResponse.movies  }
                .map { movies->
                    val movieItemUiState= mutableListOf<MovieItemUiState>()
                    movies.mapTo(movieItemUiState) { MovieItemUiState(it) }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({movies-> item.value = movies},{})    }



    class ViewModelProviderFactory(private var controller: MovieController) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
                return MovieListViewModel(controller) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}