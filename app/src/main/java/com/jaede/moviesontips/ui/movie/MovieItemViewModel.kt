package com.jaede.moviesontips.ui.movie

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jaede.moviesontips.data.model.Movie


/**
 * Created by jyotidubey on 29/12/18.
 */
class MovieItemViewModel(movie: Movie)  : ViewModel() {

    val item : MutableLiveData<Movie> by lazy {
        MutableLiveData<Movie>()
    }

    init {
       item.value = movie
    }
    class ViewModelProviderFactory(private var movie: Movie) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieItemViewModel::class.java)) {
                return MovieItemViewModel(movie = movie) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}