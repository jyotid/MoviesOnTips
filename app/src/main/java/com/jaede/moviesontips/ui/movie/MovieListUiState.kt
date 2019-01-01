package com.jaede.moviesontips.ui.movie

import android.databinding.ObservableArrayList

/**
 * Created by jyotidubey on 29/12/18.
 */
class MovieListUiState{
    interface MovieTypeSelectionHandler{
        fun onMovieSectionChanged(id:Int)
    }
    val movies =  ObservableArrayList<MovieItemUiState>()

    fun updateMovies(movies:List<MovieItemUiState> ){
        this.movies.clear()
        this.movies.addAll(movies)
    }

}