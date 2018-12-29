package com.jaede.moviesontips.ui.movie

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaede.moviesontips.R
import com.jaede.moviesontips.data.model.Movie
import com.jaede.moviesontips.databinding.FragmentMovieItemBinding

/**
 * Created by jyotidubey on 29/12/18.
 */
class MovieItemFragment : Fragment(){
    private lateinit var binding : FragmentMovieItemBinding
    private val uiState = MovieItemUiState()
    private lateinit var viewModel : MovieItemViewModel
    private lateinit var  factory : MovieItemViewModel.ViewModelProviderFactory


    companion object {
        fun getInstance(movie:Movie):MovieItemFragment{
            val fragment =  MovieItemFragment()
            val bundle = Bundle()
            bundle.putParcelable("Movie",movie)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
         binding = DataBindingUtil
                .inflate(inflater, R.layout.fragment_movie_item, container, false)
        factory = MovieItemViewModel.ViewModelProviderFactory(arguments.getParcelable<Movie>("Movie")as Movie)
        viewModel = ViewModelProviders.of(this,factory).get(MovieItemViewModel::class.java)

        setDatabindingVariables()
        setLiveDataObservers()

        return binding.root
    }


    private fun setDatabindingVariables(){
        with(binding){
            state = uiState
        }
    }

    private fun setLiveDataObservers(){
        viewModel.item.observe(this, Observer {
            it?.let { uiState.updateMovie(it) }
        })
    }
}