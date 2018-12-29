package com.jaede.moviesontips.data.model;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by jyotidubey on 28/12/18.
 */

public class MovieListResponse {

  @SerializedName("results")
  public List<Movie> movies;


}
