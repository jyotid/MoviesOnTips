package com.jaede.moviesontips.ui.movie


import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.PagerAdapter
import com.jaede.moviesontips.data.model.Movie

/**
 * Created by jyotidubey on 29/12/18.
 */
class MovieListPagerAdapter(private var fragmentManager: FragmentManager, private var items: MutableList<Movie>) : FragmentStatePagerAdapter(fragmentManager){

    override fun getItem(position: Int) = MovieItemFragment.getInstance(items[position])

    override fun getCount() = items.size

    fun clear(){
        this.items.clear()
    }
    fun addItems(items: List<Movie>){
        this.items.addAll(items)
    }
}