package com.jaede.moviesontips.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.gson.annotations.SerializedName;

/**
 * Created by jyotidubey on 28/12/18.
 */

public class Movie implements Parcelable{

  @SerializedName("title")
  public String title;

  @SerializedName("overview")
  public String overview;

  protected Movie(Parcel in) {
    title = in.readString();
    overview = in.readString();
  }

  public static final Creator<Movie> CREATOR = new Creator<Movie>() {
    @Override
    public Movie createFromParcel(Parcel in) {
      return new Movie(in);
    }

    @Override
    public Movie[] newArray(int size) {
      return new Movie[size];
    }
  };

  @Override
  public int describeContents() {
    return 0;
  }

  @Override
  public void writeToParcel(Parcel dest, int flags) {
    dest.writeString(title);
    dest.writeString(overview);
  }
}
