package com.jaede.moviesontips.data.model;

import com.google.gson.annotations.SerializedName;

/**
 * Created by jyotidubey on 29/12/18.
 */

public class PostResponseStatus {

  @SerializedName("status_code")
  public String statusCode;

  @SerializedName("status_message")
  public String statusMessage;
}

