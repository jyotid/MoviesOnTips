package com.jaede.moviesontips.data.model;

import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.NonNull;
import android.support.v7.util.DiffUtil;
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

  public static DiffUtil.ItemCallback<Movie> DIFF_CALLBACK = new DiffUtil.ItemCallback<Movie>() {
    @Override
    public boolean areItemsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
      return oldItem.title.equals(newItem.title);
    }

    @Override
    public boolean areContentsTheSame(@NonNull Movie oldItem, @NonNull Movie newItem) {
      return oldItem.equals(newItem);
    }
  };

  @Override
  public boolean equals(Object obj) {
    if (obj == this)
      return true;

    Movie article = (Movie) obj;
    return article.title.equals(this.title);
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
