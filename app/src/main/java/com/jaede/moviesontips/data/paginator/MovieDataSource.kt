package com.jaede.moviesontips.data.paginator

import android.arch.paging.PageKeyedDataSource
import com.jaede.moviesontips.data.model.Movie

/**
 * Created by jyotidubey on 16/01/19.
 */
abstract class MovieDataSource : PageKeyedDataSource<Int, Movie>()