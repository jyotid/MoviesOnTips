package com.jaede.moviesontips.ui.movie

import android.databinding.ObservableArrayList
import com.jaede.moviesontips.data.model.Movie

/**
 * Created by jyotidubey on 29/12/18.
 */
class MovieListUiState{
    interface MovieTypeSelectionHandler{
        fun onMovieSectionChanged(id:Int)
    }
    val movies =  ObservableArrayList<Movie>()

    fun updateMovies(movies:List<Movie> ){
        this.movies.clear()
        this.movies.addAll(movies)
    }

}