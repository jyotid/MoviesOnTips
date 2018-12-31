package com.jaede.moviesontips.ui.movie

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.jaede.moviesontips.R
import com.jaede.moviesontips.controller.MovieControllerImpl
import com.jaede.moviesontips.data.api.MovieApiImpl
import com.jaede.moviesontips.data.api.retrofit.MovieService
import com.jaede.moviesontips.data.api.retrofit.MovieServiceGenerator
import com.jaede.moviesontips.databinding.ActivityMovieListBinding
import kotlinx.android.synthetic.main.activity_movie_list.*

class MovieListActivity : AppCompatActivity(), MovieListUiState.MovieTypeSelectionHandler  {

    private val factory = MovieListViewModel.ViewModelProviderFactory(MovieControllerImpl(MovieApiImpl(MovieServiceGenerator.createService(MovieService::class.java))))
    private val uiState = MovieListUiState()
    private lateinit var viewModel : MovieListViewModel
    private lateinit var binding: ActivityMovieListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this@MovieListActivity, R.layout.activity_movie_list)
        viewModel = ViewModelProviders.of(this,factory).get(MovieListViewModel::class.java)
        viewPager.adapter = MovieListPagerAdapter(supportFragmentManager, mutableListOf())
        setDatabindingVariables()
        setLiveDataObservers()
    }

    private fun setDatabindingVariables(){
        with(binding){
            state = uiState
            handler = this@MovieListActivity

        }
    }

    private fun setLiveDataObservers(){
        viewModel.item.observe(this, Observer {
            it?.let { uiState.updateMovies(it) }
        })
    }
    override fun onMovieSectionChanged(viewType: Int) {
       when (viewType){
           R.id.upcoming->viewModel.loadUpcomingMovies()
           R.id.topRated->viewModel.loadTopRatedMovies()
           else->viewModel.loadNowRunningMovies()
       }

    }

}
