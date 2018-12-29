package com.jaede.moviesontips.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jyotidubey on 29/12/18.
 */

public class ApiError extends Throwable {
  @SerializedName("status_code")
  private int statusCode;
  @SerializedName("status_message")
  private String message;

  public ApiError() {
  }

  public int status() {
    return statusCode;
  }

  public String message() {
    return message;
  }
}
