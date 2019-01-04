package com.jaede.moviesontips.data.api.retrofit;

import com.jaede.moviesontips.data.model.Movie;
import com.jaede.moviesontips.data.model.MovieListResponse;
import com.jaede.moviesontips.data.model.PostResponseStatus;
import com.jaede.moviesontips.data.model.Rating;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;

/**
 * Created by jyotidubey on 28/12/18.
 */

public interface MovieService {
  @GET("/3/movie/top_rated")
  Call<MovieListResponse> getTopRatedMovies(
      @Query("api_key") String api_key,
      @Query("language") String language,
      @Query("page") int page);

  @GET("/3/movie/now_playing")
  Call<MovieListResponse> getNowRunningMovies(
      @Query("api_key") String api_key,
      @Query("language") String language,
      @Query("page") int page);

  @GET("/3/movie/upcoming")
  Call<MovieListResponse> getUpcomingMovies(
      @Query("api_key") String api_key,
      @Query("language") String language,
      @Query("page") int page);

  @POST("/3/movie/{movie_id}/rating")
  Call<PostResponseStatus>  rateMovie(@Path("movie_id") Long movie_id,
      @Query("api_key") String api_key, @Body Rating task);


  @POST("/3/movie/{movie_id}")
  Call<Movie>  getMovie(@Path("movie_id") Long movie_id,
      @Query("api_key") String api_key);
}

