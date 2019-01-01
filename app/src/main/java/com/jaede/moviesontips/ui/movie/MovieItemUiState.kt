package com.jaede.moviesontips.ui.movie

import android.databinding.ObservableField
import com.jaede.moviesontips.data.model.Movie

/**
 * Created by jyotidubey on 02/01/19.
 */
class MovieItemUiState(val movie: Movie) {
    interface MovieSelectionHandler {
        fun onMovieSelected(movie: Movie)
    }

}