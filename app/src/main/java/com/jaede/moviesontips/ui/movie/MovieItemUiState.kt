package com.jaede.moviesontips.ui.movie

import android.databinding.ObservableField
import com.jaede.moviesontips.data.model.Movie

/**
 * Created by jyotidubey on 29/12/18.
 */
class MovieItemUiState{

    val movie = ObservableField<Movie>()

    fun updateMovie(movie: Movie){
        this.movie.set(movie)
    }


}