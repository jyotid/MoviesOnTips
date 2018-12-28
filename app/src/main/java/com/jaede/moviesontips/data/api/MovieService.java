package com.jaede.moviesontips.data.api;

import com.jaede.moviesontips.data.model.MovieListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by jyotidubey on 28/12/18.
 */

public interface MovieService {
  @GET("/3/movie/top_rated")
  public Call<MovieListResponse> getMovies(
      @Query("api_key") String api_key,
      @Query("language") String language,
      @Query("page") int page);
}
