package com.jaede.moviesontips.data.api.retrofit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by jyotidubey on 28/12/18.
 */

public class MovieServiceGenerator {

  private static final String BASE_URL = "https://api.themoviedb.org/";
  private static OkHttpClient.Builder httpClient = new OkHttpClient.Builder();

  private static Retrofit.Builder builder = new Retrofit.Builder()
      .baseUrl(BASE_URL)
      .client(httpClient.build())
      .addConverterFactory(GsonConverterFactory.create());

  public static Retrofit retrofit = builder.build();

  public static <S> S createService(Class<S> serviceClass) {
      return retrofit.create(serviceClass);
  }
}
