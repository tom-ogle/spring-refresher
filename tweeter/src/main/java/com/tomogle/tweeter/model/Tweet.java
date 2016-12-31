package com.tomogle.tweeter.model;

import java.util.Date;

public class Tweet {
  private final Long id;
  private final String message;
  private final Date time;
  private Double latitude;
  private Double longitude;

  public Tweet(final Long id, final String message, final Date time, final Double latitude, final Double longitude) {
    this.id = id;
    this.message = message;
    this.time = time;
    this.latitude = latitude;
    this.longitude = longitude;
  }

  public Long getId() {
    return id;
  }

  public String getMessage() {
    return message;
  }

  public Date getTime() {
    return time;
  }

  public Double getLatitude() {
    return latitude;
  }

  public Double getLongitude() {
    return longitude;
  }

  @Override public boolean equals(final Object o) {
    if(this == o)
      return true;
    if(o == null || getClass() != o.getClass())
      return false;

    Tweet tweet = (Tweet) o;

    if(id != null ? !id.equals(tweet.id) : tweet.id != null)
      return false;
    if(message != null ? !message.equals(tweet.message) : tweet.message != null)
      return false;
    if(time != null ? !time.equals(tweet.time) : tweet.time != null)
      return false;
    if(latitude != null ? !latitude.equals(tweet.latitude) : tweet.latitude != null)
      return false;
    return longitude != null ? longitude.equals(tweet.longitude) : tweet.longitude == null;
  }

  @Override public int hashCode() {
    int result = id != null ? id.hashCode() : 0;
    result = 31 * result + (message != null ? message.hashCode() : 0);
    result = 31 * result + (time != null ? time.hashCode() : 0);
    result = 31 * result + (latitude != null ? latitude.hashCode() : 0);
    result = 31 * result + (longitude != null ? longitude.hashCode() : 0);
    return result;
  }
}
