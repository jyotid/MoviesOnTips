package com.jaede.moviesontips.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jyotidubey on 28/12/18.
 */

public class MovieResponse {

  @SerializedName("title")
  public String title;

  @SerializedName("overview")
  public String overview;

}
