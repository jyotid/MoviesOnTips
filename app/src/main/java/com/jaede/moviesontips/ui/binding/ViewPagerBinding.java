package com.jaede.moviesontips.ui.binding;

import android.databinding.BindingAdapter;
import android.support.v4.view.ViewPager;
import com.jaede.moviesontips.ui.movie.MovieListPagerAdapter;
import java.util.ArrayList;

/**
 * Created by jyotidubey on 29/12/18.
 */

public class ViewPagerBinding {
  @BindingAdapter({"items"})
  public static void setAdapter(ViewPager viewPager, ArrayList items) {
    MovieListPagerAdapter adapter = (MovieListPagerAdapter) viewPager.getAdapter();
    adapter.clear();
    adapter.addItems(items);
    adapter.notifyDataSetChanged();
  }

}
