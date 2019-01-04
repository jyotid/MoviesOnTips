package com.jaede.moviesontips.ui.movie

import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import com.jaede.moviesontips.controller.MovieController
import com.jaede.moviesontips.data.model.MovieListResponse
import com.jaede.moviesontips.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject

/**
 * TODO:Ensure that whenever new movie type is selected, previous should get cancelled
 * TODO: Fetch movie detail and display
 * Created by jyotidubey on 29/12/18.
 */
class MovieListViewModel(private var controller: MovieController) : BaseViewModel() {

    enum class MOVIE_TYPE {
        NOW_RUNNING, UPCOMING, TOP_RATED
    }

    val item: MutableLiveData<List<MovieItemUiState>> by lazy {
        MutableLiveData<List<MovieItemUiState>>()
    }

    val subject = PublishSubject.create<MOVIE_TYPE>()

    init {
        subscribeForFetchingMovies()
    }

    private fun subscribeForFetchingMovies() {
        subject
                .switchMapSingle { type->
                    when(type){
                        MOVIE_TYPE.NOW_RUNNING->return@switchMapSingle controller.getNowPlayingMovies().onErrorReturn { MovieListResponse() }
                        MOVIE_TYPE.UPCOMING->return@switchMapSingle controller.getUpcomingMovies().onErrorReturn { MovieListResponse() }
                        MOVIE_TYPE.TOP_RATED->return@switchMapSingle controller.getTopRatedMovies().onErrorReturn { MovieListResponse() }
                    }
                }
                .map { movieResponse ->
                    val movies = movieResponse.movies
                    val movieItemUiState = mutableListOf<MovieItemUiState>()
                    movies.mapTo(movieItemUiState) { MovieItemUiState(it) }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe ({movies -> this.item.value = movies },{ err-> System.out.println("ERRORRRRR")})

    }

    class ViewModelProviderFactory(private var controller: MovieController) : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
                return MovieListViewModel(controller) as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}


