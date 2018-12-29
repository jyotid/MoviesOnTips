package com.jaede.moviesontips.data.api;

import com.jaede.moviesontips.data.api.retrofit.MovieServiceGenerator;
import com.jaede.moviesontips.data.model.ApiError;
import java.io.IOException;
import java.lang.annotation.Annotation;
import okhttp3.ResponseBody;
import retrofit2.Converter;
import retrofit2.Response;

/**
 * Created by jyotidubey on 29/12/18.
 */

public class ErrorUtil {

  public static ApiError parseError(Response<?> response) {
    Converter<ResponseBody, ApiError> converter =
        MovieServiceGenerator.retrofit
            .responseBodyConverter(ApiError.class, new Annotation[0]);

    ApiError error;

    try {
      error = converter.convert(response.errorBody());
    } catch (IOException e) {
      return new ApiError();
    }

    return error;
  }
}
