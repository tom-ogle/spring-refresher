package com.tomogle.tweeter.repository;

import com.tomogle.tweeter.model.Tweet;

import java.util.List;

public interface TweetRepository {
  List<Tweet> findTweets(long max, int count);
}
