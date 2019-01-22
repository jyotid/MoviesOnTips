package com.jaede.moviesontips.ui.movie

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import com.jaede.moviesontips.R
import com.jaede.moviesontips.data.model.Movie
import com.jaede.moviesontips.databinding.ActivityMovieListBinding
import com.jaede.moviesontips.ui.base.BaseActivity
import kotlinx.android.synthetic.main.activity_movie_list.*

/***
 * LEARN Pagination lib and use if for movie list pagination
 */

class MovieListActivity : BaseActivity(), MovieListUiState.MovieTypeSelectionHandler, MovieItemUiState.MovieSelectionHandler {
    private val factory = MovieListViewModel.ViewModelProviderFactory()
    private val uiState = MovieListUiState()
    private lateinit var viewModel : MovieListViewModel
    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MovieListActivity, R.layout.activity_movie_list)
        viewModel = ViewModelProviders.of(this,factory).get(MovieListViewModel::class.java)
        viewPager.layoutManager = LinearLayoutManager(this)
        viewPager.adapter = MovieListAdapter(this)
        setDatabindingVariables()
        setLiveDataObservers()

        viewModel.newItem.observe(this, Observer {
            it?.pagedList?.observe(this@MovieListActivity, Observer {
                (viewPager.adapter as MovieListAdapter).submitList(it)
            })
        })
    }

    private fun setDatabindingVariables(){
        with(binding){
            state = uiState
            handler = this@MovieListActivity
        }
    }

    override fun onMovieSelected(movie: Movie) {
        System.out.println("Entering here with movie id ${movie.title}")
    }
    private fun setLiveDataObservers(){
        viewModel.item.observe(this, Observer {
            it?.let { uiState.updateMovies(it) }
        })
    }
    override fun onMovieSectionChanged(viewType: Int) {
        when(viewType) {
            R.id.upcoming->viewModel.subject.onNext(MovieListViewModel.MOVIE_TYPE.UPCOMING)
            R.id.topRated->viewModel.subject.onNext(MovieListViewModel.MOVIE_TYPE.TOP_RATED)
            R.id.nowRunning->viewModel.subject.onNext(MovieListViewModel.MOVIE_TYPE.NOW_RUNNING)
            else->viewModel.subject.onNext(MovieListViewModel.MOVIE_TYPE.NOW_RUNNING)
        }

    }

}
