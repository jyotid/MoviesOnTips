package com.jaede.moviesontips.ui.movie

import android.arch.paging.PagedListAdapter
import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.jaede.moviesontips.R
import com.jaede.moviesontips.data.model.Movie
import com.jaede.moviesontips.databinding.ItemMovieNewBinding

/**
 * Created by jyotidubey on 14/01/19.
 */
class MovieListAdapter(private var handler: MovieItemUiState.MovieSelectionHandler) : PagedListAdapter<Movie, MovieListAdapter.MovieViewHolder>(Movie.DIFF_CALLBACK){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =  DataBindingUtil.inflate<ItemMovieNewBinding>(LayoutInflater.from(parent?.context), R.layout.item_movie_new,parent,false)
        return MovieViewHolder(itemView,handler)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        bindItemViews(holder,position)
    }

    private fun bindItemViews(holder: MovieListAdapter.MovieViewHolder?, position: Int){
        holder?.bindItems(getItem(position))
    }

    class MovieViewHolder(private var binding: ItemMovieNewBinding, private var handler: MovieItemUiState.MovieSelectionHandler) : RecyclerView.ViewHolder(binding.root){

        fun bindItems(movie: Movie?) {
            binding.state = movie
            binding.handler = handler

        }
    }


}