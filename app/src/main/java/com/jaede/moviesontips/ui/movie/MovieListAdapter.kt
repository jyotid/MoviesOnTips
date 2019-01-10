package com.jaede.moviesontips.ui.movie


import android.databinding.DataBindingUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jaede.moviesontips.R
import com.jaede.moviesontips.databinding.ItemMovieItemBinding

/**
 * Created by jyotidubey on 29/12/18.
 */
class MovieListAdapter(private var items: MutableList<MovieItemUiState>,private var handler: MovieItemUiState.MovieSelectionHandler) : RecyclerView.Adapter<MovieListAdapter.MovieViewHolder>(){

    override fun getItemCount() = items.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val itemView =  DataBindingUtil.inflate<ItemMovieItemBinding>(LayoutInflater.from(parent?.context),R.layout.item_movie_item,parent,false)
        return MovieViewHolder(itemView,itemView.root,items,handler)
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        bindItemViews(holder,position)
    }


    private fun bindItemViews(holder: MovieListAdapter.MovieViewHolder?, position: Int){
        holder?.bindItems(position)
    }

    fun addItems(movies:List<MovieItemUiState>){
        this.items.clear()
        this.items.addAll(movies)
    }

    class MovieViewHolder(private var binding:ItemMovieItemBinding,item:View, private var items: MutableList<MovieItemUiState>,private var handler: MovieItemUiState.MovieSelectionHandler) : RecyclerView.ViewHolder(item){

        fun bindItems(position: Int) {
            binding.state = items[position]
            binding.handler = handler


        }
    }


}