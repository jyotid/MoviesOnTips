package com.jaede.moviesontips.ui.movie

import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.jaede.moviesontips.data.model.Movie
import com.jaede.moviesontips.data.paginator.MovieDataSourceFactory
import com.jaede.moviesontips.ui.base.BaseViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import io.reactivex.subjects.PublishSubject


/**
 * TODO:Ensure that whenever new movie type is selected, previous should get cancelled
 * TODO: Fetch movie detail and display
 * Created by jyotidubey on 29/12/18.
 */
class MovieListViewModel() : BaseViewModel() {

    enum class MOVIE_TYPE {
        NOW_RUNNING, UPCOMING, TOP_RATED
    }

    val item: MutableLiveData<List<MovieItemUiState>> by lazy {
        MutableLiveData<List<MovieItemUiState>>()
    }

    var newItem  = MutableLiveData<PagedResource<Movie>>()

    val subject = PublishSubject.create<MOVIE_TYPE>()

    private val pagedListConfig = PagedList.Config.Builder()
            .setEnablePlaceholders(true)
            .setInitialLoadSizeHint(10)
            .setPageSize(10).build()

    init {
        subscribeForFetchingMovies()
    }


    data class PagedResource<T>(val pagedList: LiveData<PagedList<T>>)

    private fun subscribeForFetchingMovies() {
        subject
                .map { type ->
                    when (type) {
                        MOVIE_TYPE.NOW_RUNNING -> return@map LivePagedListBuilder(MovieDataSourceFactory(MovieDataSourceFactory.MOVIE_TYPE.NOW_RUNNING), pagedListConfig).build()
                        MOVIE_TYPE.UPCOMING -> return@map LivePagedListBuilder(MovieDataSourceFactory(MovieDataSourceFactory.MOVIE_TYPE.UPCOMING), pagedListConfig)
                                .build()
                        MOVIE_TYPE.TOP_RATED -> return@map LivePagedListBuilder(MovieDataSourceFactory(MovieDataSourceFactory.MOVIE_TYPE.TOP_RATED), pagedListConfig)
                                .build()
                    }
                }
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe({ movies -> newItem.postValue(PagedResource(movies)) }, { err -> System.out.println("ERRORRRRR") })

    }

    class ViewModelProviderFactory : ViewModelProvider.NewInstanceFactory() {

        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            if (modelClass.isAssignableFrom(MovieListViewModel::class.java)) {
                return MovieListViewModel() as T
            }
            throw IllegalArgumentException("Unknown ViewModel class: " + modelClass.name)
        }
    }
}


