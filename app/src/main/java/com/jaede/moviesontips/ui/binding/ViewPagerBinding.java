package com.jaede.moviesontips.ui.binding;

import android.databinding.BindingAdapter;
import android.support.v7.widget.RecyclerView;
import com.jaede.moviesontips.ui.movie.MovieListAdapter;
import java.util.ArrayList;

/**
 * Created by jyotidubey on 29/12/18.
 */

public class ViewPagerBinding {
  @BindingAdapter({"items"})
  public static void setAdapter(RecyclerView recyclerView, ArrayList items) {
    MovieListAdapter adapter = (MovieListAdapter) recyclerView.getAdapter();
    adapter.addItems(items);
    adapter.notifyDataSetChanged();

  }

}
